package encryptdecrypt;

import encryptdecrypt.datasource.DataSourceFactory;
import encryptdecrypt.datasource.DataSourceInterface;
import encryptdecrypt.dto.Arguments;
import encryptdecrypt.service.ArgumentsParser;
import encryptdecrypt.service.EncryptionDecryptionStrategyInterface;
import encryptdecrypt.service.EncryptionDecryptionStrategyResolver;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Arguments arguments;

        try {
            arguments = ArgumentsParser.parse(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        fillMissingArgumentsFromStandardInput(arguments);

        try {
            String result = performOperation(arguments);

            if (arguments.resultShouldBeSavedToFile()) {
                DataSourceInterface dataSource = DataSourceFactory.createDataSource("file", arguments);
                dataSource.saveData(result);
            } else {
                System.out.println(result);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void fillMissingArgumentsFromStandardInput(Arguments arguments) {
        if (arguments.getData() == null && arguments.getInFile() == null) {
            Scanner sc = new Scanner(System.in);

            if (sc.hasNextLine()) {
                arguments.setData(sc.nextLine());
            }

            sc.close();
        }
    }

    private static String performOperation(Arguments arguments) throws IOException{
        EncryptionDecryptionStrategyInterface encryptorDecryptor = EncryptionDecryptionStrategyResolver.resolve(arguments);

        if (arguments.isEncryptionMode()) {
            return encryptorDecryptor.encrypt(getData(arguments), arguments.getKey());
        }

        return encryptorDecryptor.decrypt(getData(arguments), arguments.getKey());
    }

    private static String getData(Arguments arguments) throws IOException {
        if (arguments.getInFile() != null) {
            DataSourceInterface dataSource = DataSourceFactory.createDataSource("file", arguments);

            return dataSource.getData();
        }

        return arguments.getData();
    }
}