package ppg.experiment.java.monads.oologgingmonad.improved;

import ppg.experiment.java.monads.oologgingmonad.ResultWithLogMonad;

public class Main {
    public static void main(String[] args) {
        BetterResultWithLogMonad<Long> m = BetterResultWithLogMonad.of(0.5)
                .flatMap(r -> Functions.sin(r))
                .flatMap(r -> Functions.cube(r))
                .flatMap(r -> Functions.round(r));
        System.out.println(m);


    }
}
