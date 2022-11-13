package lotto.model;

public class User {

    private String changeWord;

    public User() {}

    public User(String changeWord) {
        this.changeWord = changeWord;
    }

    public void validateUserMoney(String userInput) {
        validateNotNull(userInput);
        validateNumber(userInput);
        validateNoChange(Integer.parseInt(userInput));
    }

    private void validateNotNull(String userInput) {
        if (userInput == null || userInput == "" || "0".equals(userInput)) {
            throw new IllegalArgumentException(changeWord + "은 0이상의 값을 입력하세요.");
        }
    }

    private int validateNumber(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(changeWord + "은 숫자만 입력 가능합니다.");
        }
    }

    private void validateNoChange(int userMoney) {
        if (userMoney % 1000 != 0) {
            throw new IllegalArgumentException(changeWord + "은 1000원 단위어야 합니다");
        }
    }

}
