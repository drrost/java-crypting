package encryptdecrypt.alg;

public class ShiftAlgorithm implements Algorithm {

    @Override
    public String encrypt(String input, int key) {
        String result = "";
        for (int i = 0, l = input.length(); i < l; i++) {
            int ch = input.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (ch + key - 'A') % 26 + 'A';
            } else if (ch >= 'a' && ch <= 'z') {
                ch = (ch + key - 'a') % 26 + 'a';
            }
            result += (char) ch;
        }
        return result;
    }

    @Override
    public String decrypt(String input, int key) {
        String result = "";
        for (int i = 0, l = input.length(); i < l; i++) {
            int ch = input.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (ch - key - 'Z') % 26 + 'Z';
            } else if (ch >= 'a' && ch <= 'z') {
                ch = (ch - key - 'z') % 26 + 'z';
            }
            result += (char) ch;
        }
        return result;
    }
}
