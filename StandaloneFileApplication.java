import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StandaloneFileApplication {
    public static void main(String[] args) {
        String result = parse(args);
        System.out.println(result);
    }

    public static String parse(String... inputAddress) {
        return parse(Stream.of(inputAddress).collect(Collectors.joining("\n")).trim());
    }

    public static String parse(String inputAddress) {
        String lines[] = inputAddress.split("\\n");
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].toUpperCase().startsWith("ATTN:") || lines[i].toUpperCase().startsWith("FAO:")) {
                String temp = lines[0];
                lines[0] = lines[i];
                lines[i] = temp;
            }
        }
        return Stream.of(lines).collect(Collectors.joining("\n")).trim();
    }


}