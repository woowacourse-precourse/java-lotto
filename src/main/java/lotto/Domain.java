package lotto;

public class Domain {
    public boolean isValidPriceInput(String input) {
        if (!input.matches("^[0-9]+$")) {
            return false;
        }
        int inputPrice = Integer.parseInt(input);
        if (inputPrice % 1000 != 0) {
            return false;
        }

        return true;
    }

    
}
