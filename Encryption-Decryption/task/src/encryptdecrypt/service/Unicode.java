package encryptdecrypt.service;

public class Unicode implements EncryptionDecryptionStrategyInterface {
    @Override
    public String encrypt(String inputStr, int key) {
        return process(inputStr, key);
    }

    @Override
    public String decrypt(String inputStr, int key) {
        return process(inputStr, (-1) * key);
    }

    private String process(String inputStr, int key) {
        char[] data = inputStr.toCharArray();

        for (int i = 0; i < data.length; i++) {
            data[i] = (char) (data[i] + key);
        }

        return new String(data);
    }
}
