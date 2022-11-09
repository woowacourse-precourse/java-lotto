package lotto.validator;

public class UserInputValidator {

    public void validateLottoPurchaseMoney(String lottoPurchaseMoney) {
        try {
            Integer.parseInt(lottoPurchaseMoney);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputLottoNumber(String[] winNumber) {
        validateLottoWinNumberLength(winNumber);
        validateLottoWinNumberOverlap(winNumber);
        for (String number : winNumber) {
            validateLottoNumberRange(number);
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

    public static void validateLottoWinNumberLength(String[] winNumber) {
        if (winNumber.length > 6) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자를 포함하지 않은 로또 번호 갯수는 최대 6개입니다.");
        }
    }

    public static void validateLottoWinNumberLengthContainBonusNumber(String[] winNumber) {
        if (winNumber.length > 7) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자를 포함한 로또 번호 갯수는 최대 7개입니다.");
        }
    }
}
