package lotto;

import java.util.List;

public enum Check {
    NOT_COUNT_SIX("[ERROR] 로또 번호는 6개의 숫자여야 합니다."),
    NOT_BOUNDARY("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다."),
    NOT_1000("[ERROR] 구입 금액은 1000원 단위입니다."),
    NOT_DUPLICATED_NUMBER("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    NOT_NUMBER("[ERROR] 입력값은 숫자이여야 합니다.");

    private String checkMSG;
    Check(){};
    Check(String checkMSG){
        this.checkMSG = checkMSG;
    }
    public String getCheck(){
        return checkMSG;
    }

    public static void correctNumber(String input){
        if (!input.matches("^[0-9]*$")){
            throw new IllegalArgumentException(NOT_NUMBER.getCheck());
        }
    }

    public static void validateSixNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_COUNT_SIX.getCheck());
        }
    }

    public static void validateMoney(int money){
        if (money >= 1000 && money % 1000 != 0){
            throw new IllegalArgumentException(NOT_1000.getCheck());
        }
    }

    public static void validateBoundary(List<Integer> numbers) {

        for (Integer number : numbers) {
            if (number < 1 || number > 45)
                throw new IllegalArgumentException(NOT_BOUNDARY.getCheck());
        }
    }

    public static void validateBonusBoundary(int bonusNum) {

        if (bonusNum < 1 || bonusNum > 45)
            throw new IllegalArgumentException(NOT_BOUNDARY.getCheck());

    }

}

