package encryptdecrypt.service;

import encryptdecrypt.dto.Arguments;
import encryptdecrypt.enumeration.AlgorithmType;

public class ArgumentsParser {
    public static Arguments parse(String[] args) {
        Arguments arguments = new Arguments();

        for (int i = 0; i < args.length; i++) {
            if (Arguments.MODE_KEY.equals(args[i])) {
                arguments.setMode(args[i+1]);
            }

            if (Arguments.ALGORITHM_KEY.equals(args[i])) {
                arguments.setAlgorithm(AlgorithmType.valueOf(args[i+1].toUpperCase()));
            }

            if (Arguments.DATA_KEY.equals(args[i])) {
                arguments.setData(args[i+1]);
            }

            if (Arguments.KEY_KEY.equals(args[i])) {
                arguments.setKey(Integer.parseInt(args[i+1]));
            }

            if (Arguments.IN_FILE_KEY.equals(args[i])) {
                arguments.setInFile(args[i+1]);
            }

            if (Arguments.OUT_FILE_KEY.equals(args[i])) {
                arguments.setOutFile(args[i+1]);
            }
        }

        return arguments;
    }
}
