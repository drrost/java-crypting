package encryptdecrypt.alg;

public interface Algorithm {

    String encrypt(String input, int key);
    String decrypt(String input, int key);
}
