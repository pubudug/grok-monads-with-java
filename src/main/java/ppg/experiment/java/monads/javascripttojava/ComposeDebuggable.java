package ppg.experiment.java.monads.javascripttojava;


import org.javatuples.Pair;

import java.util.function.BiFunction;

public class ComposeDebuggable {
    public static void main(String[] args) {
        DoubleToPairFunction<Double, String> sine = x -> new Pair<>(Math.sin(x), "sin called.");
        DoubleToPairFunction<Double, String> cube = x -> new Pair<>(x * x * x, "cube called.");


        BiFunction<DoubleToPairFunction<Double, String>, DoubleToPairFunction<Double, String>, DoubleToPairFunction<Double, String>>
                composeDebuggable = (f, g) -> x -> {
            Pair<Double, String> gx = g.apply(x);
            Double y = gx.getValue0();
            String s = gx.getValue1();
            Pair<Double, String> fy = f.apply(y);
            Double z = fy.getValue0();
            String t = fy.getValue1();
            return new Pair<>(z, s + t);
        };

        System.out.println(composeDebuggable.apply(cube, sine).apply(0.5));
    }
}
