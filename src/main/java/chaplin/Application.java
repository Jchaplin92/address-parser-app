package chaplin;

import static chaplin.AddressParser.parse;

public class Application {
    public static void main(String[] args) {
        String result = parse(args);
        System.out.println(result);
    }
}