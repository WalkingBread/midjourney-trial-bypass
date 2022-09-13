package skorupinski.midjourney.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private final BufferedReader reader;

    public FileReader(String path) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(path);
        InputStreamReader isReader = new InputStreamReader(is);

        reader = new BufferedReader(isReader);
    }

    public List<String> getLines() {
        List<String> lines = new ArrayList<>();
        try {
            String line;
            while((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
