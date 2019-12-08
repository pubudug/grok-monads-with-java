package ppg.experiment.java.monads.oologgingmonad.improved;

import java.util.function.Function;

public class BetterResultWithLogMonad<T> {
    private final T result;
    private final String log;

    private BetterResultWithLogMonad(T result, String log) {
        this.result = result;
        this.log = log;
    }

    static <T> BetterResultWithLogMonad<T> of(T t) {
        return new BetterResultWithLogMonad<>(t, "");
    }

    static <T> BetterResultWithLogMonad<T> of(T t, String log) {
        return new BetterResultWithLogMonad<>(t, log);
    }


    <U> BetterResultWithLogMonad<U> flatMap(Function<T, BetterResultWithLogMonad<U>> mapper) {
        BetterResultWithLogMonad<U> resultWithLog = mapper.apply(result);
        return BetterResultWithLogMonad.of(resultWithLog.getResult(), this.log + resultWithLog.getLog());
    }

    public T getResult() {
        return result;
    }

    public String getLog() {
        return log;
    }


    @Override
    public String toString() {
        return result.toString() + " " + log;
    }
}
