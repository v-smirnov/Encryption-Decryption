package encryptdecrypt.service;

import encryptdecrypt.dto.Arguments;
import encryptdecrypt.enumeration.AlgorithmType;

public class EncryptionDecryptionStrategyResolver {
    public static EncryptionDecryptionStrategyInterface resolve(Arguments arguments) {
        if (arguments.getAlgorithm() == AlgorithmType.SHIFT) {
            return new Shift();
        }

        return new Unicode();
    }
}
