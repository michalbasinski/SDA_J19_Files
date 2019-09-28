package pl.sda.files.json;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class JsonReader {

    Person read(String filePath) {
        Person result = new Person();
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            String content = new String(bytes, "UTF-8");

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

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
