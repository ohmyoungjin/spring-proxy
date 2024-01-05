package hello.proxy.jdkdynamic.code;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BImpl implements BInterface{

    @Override
    public String call() {
        log.info("B 호출");
        return "B";
    }

    @Override
    public String call2() {
        log.info("BB 호출");
        return "BB";
    }
}
