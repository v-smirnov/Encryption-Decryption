package encryptdecrypt.datasource;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSystem implements DataSourceInterface {
    private String readPath;
    private String writePath;

    FileSystem(String readPath, String writePath) {
        this.readPath = readPath;
        this.writePath = writePath;
    }

    @Override
    public String getData() throws IOException {
        if (readPath == null || readPath.isEmpty()) {
            throw new IOException("Read path undefined");
        }

        try (Scanner sc = new Scanner(new File(readPath))) {
            StringBuilder sb = new StringBuilder();
            while (sc.hasNext()) {
                sb.append(sc.nextLine());
            }

            return sb.toString();
        }
    }

    @Override
    public void saveData(String data) throws IOException {
        if (writePath == null || writePath.isEmpty()) {
            throw new IOException("Write path undefined");
        }

        try (PrintWriter writer = new PrintWriter(new File(writePath))) {
            writer.print(data);
        }
    }
}
