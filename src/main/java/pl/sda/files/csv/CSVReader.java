package pl.sda.files.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class CSVReader {
    List<Person> read(String filePath) {
        List<Person> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String headerRow = bufferedReader.readLine();
            String[] headers = headerRow.split(";");

            String record;
            while ((record = bufferedReader.readLine()) != null) {
                String[] tokens = record.split(";");
                Person person = new Person();
                for (int i = 0; i < headers.length; i++) {
                    if ("name".equals(headers[i])) {
                        person.setName(tokens[i]);
                    }
                    if ("lastName".equals(headers[i])) {
                        person.setLastName(tokens[i]);
                    }
                    if ("age".equals(headers[i])) {
                        person.setAge(Integer.parseInt(tokens[i]));
                    }
                    if ("sex".equals(headers[i])) {
                        person.setSex(Sex.valueOf(tokens[i].toUpperCase()));
                    }
                    if ("salary".equals(headers[i])) {
                        person.setSalary(Double.parseDouble(tokens[i]));
                    }
                }
                result.add(person);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
