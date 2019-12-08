package ppg.experiment.java.monads.listmonad;

class Functions {

    static ListMonad<Character> getCharacters(String s) {
        char[] chars = s.toCharArray();
        Character[] characters = new Character[chars.length];
        for (int i = 0; i < chars.length; i++) {
            characters[i] = chars[i];
        }
        return ListMonad.of(characters);
    }

    static ListMonad<Character> getBothUpperAndLowerCase(Character c) {
        return ListMonad.of(Character.toUpperCase(c), Character.toLowerCase(c));
    }
}

