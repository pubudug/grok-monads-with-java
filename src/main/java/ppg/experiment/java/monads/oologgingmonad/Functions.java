package ppg.experiment.java.monads.oologgingmonad;

class Functions {

    static ResultWithLogMonad<Double> sin(Double d) {
        return ResultWithLogMonad.of(Math.sin(d), "sin called.");
    }

    static ResultWithLogMonad<Double> cube(Double d) {
        return ResultWithLogMonad.of(d * d * d, "cube called.");
    }

    static ResultWithLogMonad<Long> round(Double d) {
        return ResultWithLogMonad.of(Math.round(d), "round called");
    }
}
