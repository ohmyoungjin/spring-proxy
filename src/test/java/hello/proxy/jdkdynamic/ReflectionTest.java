package hello.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

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


}
