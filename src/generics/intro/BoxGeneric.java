package generics.intro;

/**
 * User: MD.Ahmad
 * Date: 12/28/2019 1:26 PM
 */
public class BoxGeneric<T> {

    private T t;
    public void set(T t) { this.t = t; }
    public T get() { return t; }
}
