package encryptdecrypt.alg;

public class AlgorithmFactoryImpl implements AlgorithmFactory {

    @Override
    public Algorithm create(String type) {
        switch (type.toUpperCase()) {
            case "UNICODE":
                return new UnicodeAlgorithm();
        }
        return new ShiftAlgorithm();
    }
}
