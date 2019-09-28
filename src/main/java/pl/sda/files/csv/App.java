package pl.sda.files.csv;

import java.util.List;

class App {

    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        List<Person> personList = csvReader.read("/home/michal/SDA/Java19/Projekty/SDA_J19_Files/src/main/resources/persons.csv");
        int i = 0;
    }
}
