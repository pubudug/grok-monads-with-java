package ppg.experiment.java.monads.javascripttojava;


import org.javatuples.Pair;

import java.util.function.Function;


public class Unit {
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

        System.out.println(f.apply(unit(0.5)));
        //or
        Function<Double, Pair<Double, String>> composed = Compose.compose(Unit::unit, f);
        System.out.println(composed.apply(0.5));


        // round :: Number -> Number
        Function<Double, Double> round = (x) -> Long.valueOf(Math.round(x)).doubleValue();

        // roundDebug :: Number -> (Number,String)
        Function<Double, Pair<Double, String>> roundDebug = (x) -> unit(round.apply(x));


    }

    static <T> Pair<T, String> unit(T t) {
        return new Pair<>(t, "");
    }
}
