package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator implements Component{

    private Component component;

    public TimeDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("TimeDecorator 실행");
        Long startTimeMs = System.currentTimeMillis();
        String operation = component.operation();
        Long EndTimeMs = System.currentTimeMillis();
        long resultTime = EndTimeMs - startTimeMs;
        log.info("실행 시간={}ms", resultTime);
        return operation;
    }
}
