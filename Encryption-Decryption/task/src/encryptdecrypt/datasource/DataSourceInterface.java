package encryptdecrypt.datasource;

import java.io.IOException;

public interface DataSourceInterface {
    String getData() throws IOException;

    void saveData(String data) throws IOException;
}
