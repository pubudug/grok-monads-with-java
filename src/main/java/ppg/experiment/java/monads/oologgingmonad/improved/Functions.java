package ppg.experiment.java.monads.oologgingmonad.improved;

import ppg.experiment.java.monads.oologgingmonad.ResultWithLogMonad;

class Functions {

    static BetterResultWithLogMonad<Double> sin(Double d) {
        return BetterResultWithLogMonad.of(Math.sin(d), "sin called.");
    }

    static BetterResultWithLogMonad<Double> cube(Double d) {
        return BetterResultWithLogMonad.of(d * d * d, "cube called.");
    }

    static BetterResultWithLogMonad<Long> round(Double d) {
        return BetterResultWithLogMonad.of(Math.round(d), "round called");
    }
}
