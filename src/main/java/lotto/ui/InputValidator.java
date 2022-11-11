package lotto.ui;

import java.util.List;

public class InputValidator {

    public void validateInputDigit(String userInput) {
        for(char input : userInput.toCharArray()) {
            if(!Character.isDigit(input)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateInputRange(List<Integer> userInput) {
        for(int input : userInput) {
            if(input < 1 && input > 45) {
                throw new IllegalArgumentException();
            }
        }
    }
}
