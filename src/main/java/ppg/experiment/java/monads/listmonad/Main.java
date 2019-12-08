package ppg.experiment.java.monads.listmonad;

public class Main {
    public static void main(String[] args) {
        ListMonad<Character> result = ListMonad.of("Arnold", "Chuck", "Bruce")
                .flatMap(Functions::getCharacters)
                .flatMap(Functions::getBothUpperAndLowerCase);

        System.out.println(result);
    }
}
