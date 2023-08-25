package hello.proxy.pureproxy.decorator.decoabstract.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator extends Decorator {

    public TimeDecorator(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        log.info("TimeDecorator 실행");
        Long startTimeMs = System.currentTimeMillis();
        String operation = super.operation();
        Long EndTimeMs = System.currentTimeMillis();
        long resultTime = EndTimeMs - startTimeMs;
        log.info("실행 시간={}ms", resultTime);
        return operation;
    }
}
