package pl.sda.files.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ExcelReader {
    List<Person> read(String filePath) {
        List<Person> result = new ArrayList<>();

        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            Row firstRow = rowIterator.next();
            Iterator<Cell> cellIterator = firstRow.cellIterator();
            List<String> headers = new ArrayList<>();
            while (cellIterator.hasNext()) {
                headers.add(cellIterator.next().getStringCellValue());
            }

            while (rowIterator.hasNext()) {
                Person person = processRow(rowIterator.next(), headers);
                result.add(person);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private Person processRow(Row row, List<String> headers) {
        Person person = new Person();
        Iterator<Cell> rowCellIterator = row.cellIterator();
        int i = 0;
        while (rowCellIterator.hasNext()) {
            Cell cell = rowCellIterator.next();
            if ("name".equals(headers.get(i))) {
                person.setName(cell.getStringCellValue());
            }
            if ("lastName".equals(headers.get(i))) {
                person.setLastName(cell.getStringCellValue());
            }
            i++;
        }
        return person;
    }
}
