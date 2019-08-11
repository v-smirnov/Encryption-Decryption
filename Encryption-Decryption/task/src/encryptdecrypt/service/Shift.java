package encryptdecrypt.service;

public class Shift implements EncryptionDecryptionStrategyInterface {
    private final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public String encrypt(String inputStr, int key) {
        return process(inputStr, key);
    }

    @Override
    public String decrypt(String inputStr, int key) {
        return process(inputStr, (-1) * key);
    }

    private String process(String inputStr, int key) {
        char[] data = inputStr.toLowerCase().toCharArray();

        for (int i = 0; i < data.length; i++) {
            int index = ALPHABET.indexOf(data[i]);

            data[i] = index == -1 ? data[i] : ALPHABET.charAt(resolveIndexByKey(index, key));
        }

        return new String(data);
    }

    private static int resolveIndexByKey(int currentIndex, int key) {
        int newIndex = currentIndex + key;

        if (newIndex < 0) {
            return ALPHABET.length() + newIndex;
        }

        return newIndex >= ALPHABET.length() ? newIndex - ALPHABET.length() : newIndex;
    }
}
