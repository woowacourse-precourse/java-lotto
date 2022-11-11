package lotto.domain;

public class InputValidator {

    public void validateInputMoney(String inputMoney) {
        if (includeNotNumericCharacter(inputMoney)) {
            System.out.println(ErrorMessage.MONEY_INPUT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }

        int userMoney = Integer.parseInt(inputMoney);
        if (!isMultipleOfOneThousand(userMoney)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean includeNotNumericCharacter(String userInput) {
        for (int i = 0; i < userInput.length(); ++i) {
            if (userInput.charAt(i) < '0' || userInput.charAt(i) > '9') {
                return true;
            }
        }
        return false;
    }

    private boolean isMultipleOfOneThousand(int userMoney) {
        if (userMoney % 1000 == 0) {
            return true;
        }
        return false;
    }
}
