package hello.proxy.pureproxy.decorator.decoabstract.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator extends Decorator {


    public MessageDecorator(Component component) {
        //부모 클레스의 생성자를 호출 해서 주입 받기 위함.
        super(component);
    }

    @Override
    public String operation() {
        log.info("MessageDecorator 실행");
        String result = super.operation();
        String decoResult = "*****" + result + "*****";
        log.info("MessageDecorator 꾸미기 전={} 후={}", result, decoResult);
        return decoResult;
    }
}
