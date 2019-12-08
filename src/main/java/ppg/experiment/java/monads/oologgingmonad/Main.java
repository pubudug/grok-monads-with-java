package ppg.experiment.java.monads.oologgingmonad;

public class Main {
    public static void main(String[] args) {
        ResultWithLogMonad<Double> m = ResultWithLogMonad.of(0.5)
                .flatMap(r -> Functions.sin(r))
                .flatMap(r -> Functions.cube(r));
        System.out.println(m);
    }
}
