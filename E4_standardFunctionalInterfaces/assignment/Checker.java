package E4_standardFunctionalInterfaces.assignment;

@FunctionalInterface
public interface Checker<T> {

    public boolean check(T t);

}
