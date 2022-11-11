package lotto.ui;


public class InputValidator {

    public void validateInputDigit(String userInput) {
        for(char input : userInput.toCharArray()) {
            if(!Character.isDigit(input)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
