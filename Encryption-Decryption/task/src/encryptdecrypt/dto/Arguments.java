package encryptdecrypt.dto;

import encryptdecrypt.enumeration.AlgorithmType;

public class Arguments {
    private static final String DEFAULT_MODE = "enc";

    public static final String MODE_KEY = "-mode";
    public static final String ALGORITHM_KEY = "-alg";
    public static final String DATA_KEY = "-data";
    public static final String KEY_KEY = "-key";
    public static final String IN_FILE_KEY = "-in";
    public static final String OUT_FILE_KEY = "-out";

    private String mode;
    private AlgorithmType algorithm;
    private String data;
    private Integer key;
    private String inFile;
    private String outFile;

    public Arguments() {
        mode = DEFAULT_MODE;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public AlgorithmType getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(AlgorithmType algorithm) {
        this.algorithm = algorithm;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getInFile() {
        return inFile;
    }

    public void setInFile(String inFile) {
        this.inFile = inFile;
    }

    public String getOutFile() {
        return outFile;
    }

    public void setOutFile(String outFile) {
        this.outFile = outFile;
    }

    public boolean isEncryptionMode() {
        return mode.equals(DEFAULT_MODE);
    }

    public boolean resultShouldBeSavedToFile() {
        return outFile != null;
    }

    @Override
    public String toString() {
        return "Arguments{" +
                "mode='" + mode + '\'' +
                ", data='" + data + '\'' +
                ", key=" + key +
                '}';
    }
}
