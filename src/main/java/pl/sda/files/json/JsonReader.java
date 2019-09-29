package pl.sda.files.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class JsonReader {

    Person read(String filePath) {
        Person result = new Person();
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            String content = new String(bytes, "UTF-8");

            result = parsePersonJson(content);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    List<Person> readMultiple(String filePath) throws IOException {
        List<Person> result = new ArrayList<>();

        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        String contents = new String(bytes, "UTF-8");

        JSONArray personsJson = new JSONArray(contents);

        for (int i = 0; i < personsJson.length(); i++) {
            Object recordRaw = personsJson.get(i);
            JSONObject personJson = new JSONObject(recordRaw.toString());
            Person person = parsePersonJson(personJson.toString());
            result.add(person);
        }
        return result;
    }

    private Person parsePersonJson(String content) {
        Person result = new Person();
        JSONObject object = new JSONObject(content);
        String name = object.getString("name");
        String lastName = object.getString("lastName");
        Integer age = object.getInt("age");
        Double salary = object.getDouble("salary");

        Object addressObject = object.get("address");
        JSONObject addressJSON = new JSONObject(addressObject.toString());
        String city = addressJSON.getString("city");
        String street = addressJSON.getString("street");
        String postalCode = addressJSON.getString("postalCode");

        result.setName(name);
        result.setLastName(lastName);
        result.setAge(age);
        result.setSalary(salary);

        Address address = new Address();
        address.setCity(city);
        address.setStreet(street);
        address.setPostalCode(postalCode);

        result.setAddress(address);
        return result;
    }


}
