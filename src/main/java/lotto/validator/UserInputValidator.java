package lotto.validator;

public class UserInputValidator {

    public void validateLottoPurchaseMoney(String lottoPurchaseMoney) {
        try {
            Integer.parseInt(lottoPurchaseMoney);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
    public static void validateLottoNumberRange(String winNumber) {
        for (int index = 0; index < winNumber.length(); index++) {
            if (Integer.parseInt(winNumber) < 1 || Integer.parseInt(winNumber) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
    public static void validateLottoWinNumberOverlap(String[] winNumber) {
        String temp = winNumber[0];
        for (int numberIndex = 1; numberIndex < winNumber.length; numberIndex++) {
            if (winNumber[numberIndex].equals(temp)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }
    }
}
