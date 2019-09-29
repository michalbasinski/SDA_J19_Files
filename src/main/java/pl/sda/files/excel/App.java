package pl.sda.files.excel;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ExcelReader excelReader = new ExcelReader();
        List<Person> persons = excelReader.read("/home/michal/SDA/Java19/Projekty/SDA_J19_Files/src/main/resources/excel.xlsx");
    }
}