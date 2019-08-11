package encryptdecrypt.service;

public interface EncryptionDecryptionStrategyInterface {
    String encrypt(String inputStr, int key);

    String decrypt(String inputStr, int key);
}
