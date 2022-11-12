package lotto;

public class c4fiberParser {
    private static boolean isParsable(String input) {
        try {
            for (String s : input.split(",")){
                Integer.parseInt(s);
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Can't parse to Int");
            return false;
        }

        return true;
    }
}
