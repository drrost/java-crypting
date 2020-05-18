package encryptdecrypt.alg;

public class UnicodeAlgorithm implements Algorithm {
    @Override
    public String encrypt(String input, int key) {
        return apply(input, key);
    }

    @Override
    public String decrypt(String input, int key) {
        return apply(input, -key);
    }

    private String apply(String input, int key) {
        String result = "";
        for (int i = 0, l = input.length(); i < l; i++) {
            int ch = input.charAt(i);
            ch += key;
            result += (char) ch;
        }
        return result;
    }
}
