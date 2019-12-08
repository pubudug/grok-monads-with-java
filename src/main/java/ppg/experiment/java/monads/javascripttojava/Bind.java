package ppg.experiment.java.monads.javascripttojava;


import org.javatuples.Pair;

import java.util.function.Function;


public class Bind {
    public static void main(String[] args) {
        DoubleToPairFunction<Double, String> sine = x -> new Pair<>(Math.sin(x), "sin called.");
        DoubleToPairFunction<Double, String> cube = x -> new Pair<>(x * x * x, "cube called.");


        /**
         * takes a function that takes a Double and returns a Pair<Double,String>
         *     and converts it to
         *  a function that takes a Pair<Double, String> and returns a Pair<Double, String>
         */
        Function<DoubleToPairFunction<Double, String>, PairToPairFunction<Double, String>> bind = f -> {
            return tuple -> {
                Double y = tuple.getValue0();
                String s = tuple.getValue1();
                Pair<Double, String> fy = f.apply(y);
                Double z = fy.getValue0();
                String t = fy.getValue1();
                return new Pair<>(z, s + t);
            };
        };

        /**
         * Now we can use the compose function that we first wrote (from Compose class)
         */
        Function<Pair<Double, String>, Pair<Double, String>> f = Compose.compose(bind.apply(sine), bind.apply(cube));
        System.out.println(f.apply(new Pair<>(0.5, "")));


    }
}
