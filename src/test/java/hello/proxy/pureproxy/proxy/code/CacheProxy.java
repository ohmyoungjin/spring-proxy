package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject{

    private Subject target; //프록시가 호출할 실제 객체
    private String cacheValue; //조회 후 변경되지 않을 값 이 때는 캐시를 사용한다.

    //의존 관계 주입 (DI)
    //Client => proxy => 실제 사용되어야 할 객체
    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("프록시 호출");
        //캐시 및 접근 제어!
        if (cacheValue == null) {
            log.info("캐시가 아직 저장되지 않았습니다");
            cacheValue = target.operation();
        }

        return cacheValue;
    }
}
