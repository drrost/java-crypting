package encryptdecrypt;

public class Arguments {

    String mode;
    int key;
    String data;
    String out;
    String in;
    String algorithm;

    public Arguments(String[] args) {
        String value = valueFor("-key", args);
        key = value == null ? 0 : Integer.parseInt(value);
        data = valueFor("-data", args);
        mode = valueFor("-mode", args);
        out = valueFor("-out", args);
        in = valueFor("-in", args);
        algorithm = valueFor("-alg", args);
    }

    public String getMode() {
        return mode;
    }

    public int getKey() {
        return key;
    }

    public String getData() {
        return data;
    }

    public String getOut() {
        return out;
    }

    public String getIn() {
        return in;
    }

    // Parse argument functions

    private String valueFor(String key, String[] args) {
        for (int i = 0, n; i < args.length; i++) {
            if (args[i].equals(key)) {
                return args[i + 1];
            }
        }
        return null;
    }
}
