package pl.sda.files.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class JsonAltWriter {
    void write(Person person, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(person);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            writer.flush();
        }
    }
}
