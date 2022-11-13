package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    private String changeWord;

    public User() {}

    public User(String changeWord) {
        this.changeWord = changeWord;
    }

    public void validateUserMoney(String userInput) {
        validateNotNull(userInput);
        validateNotZero(userInput);
        validateNoSpace(userInput);
        validateNumber(userInput);
        validateNoChange(Integer.parseInt(userInput));
    }

    public void validateUserWinningNumber(String userInput) {
        validateNotNull(userInput);
        validateNoSpace(userInput);
        validateHasComma(userInput);
        validateNumberList(userInput);
    }


    private void validateNotNull(String userInput) {
        if (userInput == null || userInput == "") {
            throw new IllegalArgumentException(changeWord + "은 빈 값을 입력할 수 없습니다");
        }
    }

    private void validateNotZero(String userInput) {
        if ("0".equals(userInput)) {
            throw new IllegalArgumentException(changeWord + "은 0이상의 값을 입력하세요.");
        }
    }

    private void validateNoSpace(String userInput) {
        if(userInput!=userInput.trim() || userInput.indexOf(" ")!=-1){
            throw new IllegalArgumentException(changeWord + "은 띄어쓰기 없이 입력하세요.");
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

    private void validateHasComma(String userInput) {
        if(userInput.indexOf(",")==-1){
            throw new IllegalArgumentException(changeWord + "는 쉼표로 구분되어야 합니다");
        }
    }

    private void validateNumberList(String userInput) {
        List<String> userInputs = Arrays.asList(userInput.split(","));
        for(String userNumber : userInputs){
            validateNumber(userNumber);
        }
    }




}
