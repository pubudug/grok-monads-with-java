package ppg.experiment.java.monads.oologgingmonad;

import java.util.function.Function;

public class ResultWithLogMonad<T> {
    private final T result;
    private final String log;

    private ResultWithLogMonad(T result, String log) {
        this.result = result;
        this.log = log;
    }

    static <T> ResultWithLogMonad<T> of(T t) {
        return new ResultWithLogMonad<>(t, "");
    }

    static <T> ResultWithLogMonad<T> of(T t, String log) {
        return new ResultWithLogMonad<>(t, log);
    }

    /**
     * This is the same as bind function in the javascripttojava package.
     * The function passed as a parameter is of type T to ResultWithLog<T>
     * But flatMap goes from ResultWithLog<T> to ResultWithLog<T>
     */
    ResultWithLogMonad<T> flatMap(Function<T, ResultWithLogMonad<T>> mapper) {
        ResultWithLogMonad<T> resultWithLog = mapper.apply(result);
        return ResultWithLogMonad.of(resultWithLog.getResult(), this.log + resultWithLog.getLog());
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
