package hello.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.function.Supplier;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection0() {
        Hello target = new Hello();

        //공통 로직1 시작
        log.info("start");
        String result1 = target.callA(); //호출하는 메서드가 다름
        log.info("result={}", result1);
        //공통 로직1 종료

        //공통 로직1 시작
        log.info("start");
        String result2 = target.callB(); //호출하는 메서드가 다름
        log.info("result={}", result2);
        //공통 로직1 종료
    }

    @Slf4j
    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }

        public int callC() {
            log.info("callC");
            return 3;
        }
    }

    //lambda
    @Test
    void lambdaTest() {
        Hello target = new Hello();
        lambda(() -> target.callA());
        lambda(() -> target.callB());
        lambda(() -> target.callC());
    }

    private <T> T lambda(Supplier<T> supplier) {
        log.info("start={}", supplier);
        T result = supplier.get();
        log.info("result={}", result);
        return result;
    }

    //reflection
    @Test
    void reflection1() throws Exception{ // 해당 1번 test 에서는 method 정보가 hard coding 되기 때문에 공통 로직으로 처리 했다고 보기 어렵다.
        /*
         주의 : classHello.getMethod("callA") 부분의 파라미터를 문자열(String) 형태로 받기 때문에 문자열이 틀려도 컴파일은 정상적으로 된다.
         run time error 가 나오기 때문에 문제가 된다.
         좋은 개발자는 컴파일 시점에서 오류를 발견 하도록 소스를 개발해야 한다.
         따라서 리플렉션은 일반적으로 사용하는 것은 안된다.
         리플렉션은 프레임워크 개발이나 또는 매우 일반적인 공통 처리가 필요할 때 부분적으로 주의해서 사용해야 한다.
        */
        Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        //callA 메서드 정보
        Method methodCallA = classHello.getMethod("callA");
        Object result1 = methodCallA.invoke(target);
        log.info("result1={}", result1);

        //callB 메서드 정보
        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(target);
        log.info("result2={}", result2);
    }

    @Test
    void reflectionTest2() throws Exception { // method 정보를 parameter 로 넘기며 method 를 추상화함으로 공통 로직으로 변경.
        Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        Method methodCallA = classHello.getMethod("callA");
        //callA 메서드 정보
        dynamicCall(methodCallA, target);
        //callB 메서드 정보
        Method methodCallB = classHello.getMethod("callB");
        dynamicCall(methodCallB, target);
    }

    private void dynamicCall(Method method, Object target) throws Exception{
        log.info("start");
        Object result = method.invoke(target);
        log.info("result={}", result);
    }

}
