package ppg.experiment.java.monads.oologgingmonad;

import ppg.experiment.java.monads.oologgingmonad.improved.BetterResultWithLogMonad;

public class Main {
    public static void main(String[] args) {
        ResultWithLogMonad<Double> m = ResultWithLogMonad.of(0.5)
                .flatMap(r -> Functions.sin(r))
                .flatMap(r -> Functions.cube(r));
        System.out.println(m);


    }
}
