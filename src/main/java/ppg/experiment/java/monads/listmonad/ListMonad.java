package ppg.experiment.java.monads.listmonad;

import java.lang.reflect.Array;
import java.util.function.Function;

public class ListMonad<T> {
    private final T[] elements;

    private ListMonad(T[] elements) {
        this.elements = elements;
    }

    public static <T> ListMonad<T> of(T... elements) {
        return new ListMonad<>(elements);
    }

    <U> ListMonad<U> flatMap(Function<T, ListMonad<U>> mapper) {
        ListMonad<U> result = of();
        for (int i = 0; i < elements.length; i++) {
            result = result.addAll(mapper.apply(elements[i]));
        }
        return result;
    }

    public ListMonad<T> addAll(ListMonad<T> other) {
        T[] elems = (T[]) Array.newInstance(Object.class, elements.length + other.elements.length);
        int i = 0;
        for (; i < elements.length; i++) {
            elems[i] = elements[i];
        }
        for (; i < elements.length + other.elements.length; i++) {
            elems[i] = other.elements[i - elements.length];
        }
        return of(elems);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < elements.length; i++) {
            s += elements[i].toString() + " ";
        }
        return s;
    }
}
