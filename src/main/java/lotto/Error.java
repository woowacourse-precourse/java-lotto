package lotto;

import java.util.List;

public enum Error {
    NOT_NUMBER_COUNT_SIX("[ERROR] 로또 번호는 6개의 숫자여야 합니다."),
    NOT_NUMBER_IN_BOUNDARY("[ERROR] 로또 번호는 1~45 사이 숫자여야 합니다."),
    NOT_NUMBER_DIVIDED_1000("[ERROR] 구입 금액은 1000원 단위입니다."),
    BONUS_DUPLICATE_LOTTO("[ERROR] 보너스 번호는 로또 번호와 중복되지 않은 숫자여야 합니다."),
    NUMBER_DUPLICATE("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다."),
    INPUT_IS_NOT_NUM("[ERROR] 구입 금액은 숫자여야 합니다.");

    private String errorMsg;

    Error(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public static void validateLottoNumSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_NUMBER_COUNT_SIX.getErrorMsg());
        }
    }

    public static void validateInputIsNotNum(String input){
        if(!input.matches("^[0-9]*$"))
            throw new IllegalArgumentException(INPUT_IS_NOT_NUM.getErrorMsg());
    }

    public static void validateBuyMoneyDivided1000(int buyMoney) {
        if (buyMoney % 1000 != 0 || buyMoney == 0)
            throw new IllegalArgumentException(NOT_NUMBER_DIVIDED_1000.getErrorMsg());
    }

    public static void validateNotDuplicateLottoNum(List<Integer> numbers, int startIndex) {
        int targetNum = numbers.get(startIndex);

        for (int index = startIndex + 1; index < numbers.size(); index++) {
            if (targetNum == numbers.get(index))
                throw new IllegalArgumentException(NUMBER_DUPLICATE.getErrorMsg());
        }
    }

    public static void validateBonusNumDuplicate(List<Integer> numbers, int bonusNum) {
        if (numbers.contains(bonusNum)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_LOTTO.getErrorMsg());
        }
    }

}
