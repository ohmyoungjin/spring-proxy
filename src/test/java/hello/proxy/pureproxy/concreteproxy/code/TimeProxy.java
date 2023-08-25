package hello.proxy.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic{

    private ConcreteLogic concreteLogic;

    public TimeProxy(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    @Override
    public String operation() {
        Long stopTimeMs = System.currentTimeMillis();
        String result = super.operation();
        Long endTimeMs = System.currentTimeMillis();
        long resultTime = endTimeMs - stopTimeMs;
        log.info("timeProxy end={}ms", resultTime);
        return result;
    }
}
