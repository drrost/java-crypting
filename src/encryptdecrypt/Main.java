package encryptdecrypt;

import encryptdecrypt.alg.Algorithm;
import encryptdecrypt.alg.AlgorithmFactory;
import encryptdecrypt.alg.AlgorithmFactoryImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        Arguments arguments = new Arguments(args);

        String data = "";
        try {
            if (arguments.data != null) {
                data = arguments.data;
            } else {
                data = readDataFromFile(arguments.in);
            }
        } catch (IOException e) {
            System.out.println("Error: can't open file to read.");
            return;
        } catch (NullPointerException e) {
            System.out.println("Error: there is no input data.");
            return;
        }

        AlgorithmFactory factory = new AlgorithmFactoryImpl();
        Algorithm algorithm = factory.create(arguments.algorithm);

        String result;
        if (arguments.mode.equals("enc")) {
            result = algorithm.encrypt(data, arguments.key);
        } else {
            result = algorithm.decrypt(data, arguments.key);
        }

        if (arguments.out == null) {
            System.out.println(result);
        } else {
            try {
                writeDataToFile(arguments.out, result);
            } catch (IOException e) {
                System.out.println("Error: can't open file to write");
            }
        }
    }

    private static void writeDataToFile(String fileName, String result) throws IOException {
        Files.write(Paths.get(fileName), result.getBytes());
    }

    private static String readDataFromFile(String in) throws IOException {
        return new String(Files.readAllBytes(Paths.get(in)));
    }
}
