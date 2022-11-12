package lotto.exception;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputException {
    private static final String PRICE_INTEGER_ERROR = "[ERROR] 구입금액은 숫자여야 합니다.";
    private static final String PRICE_IS_POSITIVE_NUMBER = "[ERROR] 시도 횟수는 1이상의 양수여야 합니다.";
    private static final String PRICE_UNIT_ERROR = "[ERROR] 구입금액은 1000원 단위입니다.";
    private static final String LOTTO_NUMBER_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 숫자여야 합니다.";
    private static final String WINNING_LOTTO_ERROR = "[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.";
    private static final int MIN_PRICE_NUMBER = 1;
    private static final int MIN_UNIT_NUMBER = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;


    public static int isValidInputPrice(String input) {
        int price = validPrice(input);
        if (isUnitNumber(price) && isNaturalNumber(price)) {
            return price;
        }
        throw new IllegalArgumentException();
    }

    private static int validPrice(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PRICE_INTEGER_ERROR);
        }
    }

    private static boolean isNaturalNumber(int price) {
        if (price < MIN_PRICE_NUMBER) {
            throw new IllegalArgumentException(PRICE_IS_POSITIVE_NUMBER);
        }
        return true;
    }

    private static boolean isUnitNumber(int price) {
        if (price % MIN_UNIT_NUMBER != 0) {
            throw new IllegalArgumentException(PRICE_UNIT_ERROR);
        }
        return true;
    }

    public static Lotto isValidLottoNumber(String input) {
        Lotto lotto = parserLottoInput(input);

        for(int number : lotto.getLotto()){
            if(!isValidRangeNumber(number)){
                throw new IllegalArgumentException();
            }
        }

        return lotto;
    }

    private static Lotto parserLottoInput(String input) {
        List<String> strLotto = Arrays.asList(input.split(","));

        return new Lotto(strLotto.stream().map(Integer::parseInt).collect(Collectors.toList()));
    }


    private static boolean isValidRangeNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR);
        }
        return true;
    }

    public static int isValidBonusNumber(String input){
        int bonusNumber = validBonusNumber(input);
        if (isValidRangeNumber(bonusNumber)) {
            return bonusNumber;
        }
        throw new IllegalArgumentException();
    }

    private static int validBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR);
        }
    }

    public static WinningLotto isValidWinningLotto(Lotto winningNumber, int bonusNumber){
        for (int number : winningNumber.getLotto()){
            if (number == bonusNumber) {
                throw new IllegalArgumentException(WINNING_LOTTO_ERROR);
            }
        }

        return new WinningLotto(winningNumber, bonusNumber);
    }
}
