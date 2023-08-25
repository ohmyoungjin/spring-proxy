package hello.proxy.pureproxy.decorator.decoabstract.code;

public abstract class Decorator implements Component{

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        return component.operation();
    }
}
