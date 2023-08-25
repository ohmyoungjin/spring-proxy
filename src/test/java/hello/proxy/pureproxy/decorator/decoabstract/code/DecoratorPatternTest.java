package hello.proxy.pureproxy.decorator.decoabstract.code;


import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {

    @Test
    void abstractDecoratorRequest() {

        Decorator decorator1 = new TimeDecorator(new MessageDecorator(new RealComponent()));
        DecoratorPatternClient client = new DecoratorPatternClient(decorator1);
        client.execute();
        //decorator1.operation();

    }
}
