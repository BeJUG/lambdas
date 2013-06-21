package E3_functionalInterfaces.solution;

@FunctionalInterface
public interface Checker<T> {

    public boolean check(T t);

}
