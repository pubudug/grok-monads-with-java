package ppg.experiment.java.monads.javascripttojava;


import java.util.function.Function;

public class Compose {
    public static void main(String[] args) {
        Function<Double, Double> sine = x -> Math.sin(x);

        Function<Double, Double> cube = x -> x * x * x;


        //manual compose
        System.out.println(compose(sine, cube).apply(0.5));
        //compose method from Java API
        System.out.println(cube.compose(sine).apply(0.5));
    }

    public static <X, Y, Z> Function<X, Z> compose(Function<X, Y> g, Function<Y, Z> f) {
        return x -> f.apply(g.apply(x));
    }
}
