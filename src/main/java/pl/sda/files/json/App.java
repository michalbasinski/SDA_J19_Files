package pl.sda.files.json;

import java.io.IOException;
import java.util.List;

class App {
    public static void main(String[] args) throws IOException {
        JsonReader reader = new JsonReader();
        Person person = reader.read("/home/michal/SDA/Java19/Projekty/SDA_J19_Files/src/main/resources/person.json");

        JsonAltReader altReader = new JsonAltReader();
        Person person2 = altReader.read("/home/michal/SDA/Java19/Projekty/SDA_J19_Files/src/main/resources/person.json");

        JsonAltWriter writer = new JsonAltWriter();
        writer.write(person2, "/home/michal/personFromWriter.json");

        List<Person> people = reader.readMultiple("/home/michal/SDA/Java19/Projekty/SDA_J19_Files/src/main/resources/persons.json");
    }
}
