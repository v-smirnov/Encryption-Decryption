package encryptdecrypt.datasource;

import encryptdecrypt.dto.Arguments;
import encryptdecrypt.exception.UndefinedDataSourceTypeException;

public class DataSourceFactory {
    public static DataSourceInterface createDataSource(String type, Arguments arguments) {
        if ("file".equals(type)) {
            return new FileSystem(arguments.getInFile(), arguments.getOutFile());
        }

        throw new UndefinedDataSourceTypeException("Type is - " + type);
    }
}
