package lotto;

public class Validation {

    public void validatePriceFormat(String price) {
        char[] charNumbers = price.toCharArray();

        for (char charNumber : charNumbers) {
            if (!Character.isDigit(charNumber)) {
                System.out.println("[ERROR] price is invalid(is not digit)");
                throw new IllegalArgumentException();
            }
        }
    }
}
