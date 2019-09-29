package pl.sda.files.json;

import java.io.IOException;

class App {
    public static void main(String[] args) throws IOException {
        JsonReader reader = new JsonReader();
        Person person = reader.read("/home/michal/SDA/Java19/Projekty/SDA_J19_Files/src/main/resources/person.json");

        JsonAltReader altReader = new JsonAltReader();
        Person person2 = altReader.read("/home/michal/SDA/Java19/Projekty/SDA_J19_Files/src/main/resources/person.json");

        JSONWriter writer = new JSONWriter();
        writer.write(person2, "/home/michal/personFromWriter.json");

        int i = 0;
    }
}
