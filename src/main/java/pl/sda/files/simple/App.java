package pl.sda.files.simple;

class App {
    public static void main(String args[]) {
        SimpleFileReader reader = new SimpleFileReader();
        reader.readFile("/home/michal/SDA/Java19/Projekty/SDA_J19_Files/src/main/resources/simple.txt");

        SimpleFileWriter writer = new SimpleFileWriter();
        writer.write("Moja zawartość", "/home/michal/tttt");
    }
}
