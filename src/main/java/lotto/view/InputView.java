package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MONEY_FOR_LOTTOS = "구입금액을 입력해 주세요";
    private static final String INPUT_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String MONEY_IS_DIGIT_VALIDATION_EXCEPTION_MESSAGE = "[ERROR] 구입금액은 문자가 아닌 숫자로 입력해 주세요.";
    private static final String MONEY_DIVIDE_LOTTO_PRICE_EXCEPTION_MESSAGE = "[ERROR] 구입금액은 1,000원으로 나누어 떨어져야 합니다.";
    private static final String MONEY_START_NUMBER_IS_NOT_ZERO_EXCEPTION_MESSAGE = "[ERROR] 구입금액의 시작값은 0이 아닌 1-9의 값으로 시작해야 합니다.";
    private static final String WINNING_LOTTO_NUMBERS_IS_DIGIT_EXCEPTION_MESSAGE = "[ERROR] 당첨번호는 숫자여야 합니다.";
    private static final String BONUS_NUMBER_IS_DIGIT_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 문자가 아닌 숫자여야 합니다.";
    private static final String BONUS_NUMBER_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복되어선 안됩니다.";
    private static final int LOTTO_PRICE = 1000;
    private static final char ZERO = '0';

    public int inputMoneyForLottos() {
        System.out.println(INPUT_MONEY_FOR_LOTTOS);
        String moneyForLottos = Console.readLine();
        moneyStartLetterIsNotZeroExceptionCheck(moneyForLottos);
        inputMoneyIsDigitValidationExceptionCheck(moneyForLottos);
        inputMoneyDivideLottoPriceExceptionCheck(moneyForLottos);
        return Integer.parseInt(moneyForLottos);
    }

    public Lotto inputWinningLottoNumber() {
        System.out.println(INPUT_WINNING_NUMBERS);
        String[] winningLottoNumbers = Console.readLine().split(",");
        winningLottoNumbersIsDigitExceptionCheck(winningLottoNumbers);
        return getWinningLotto(winningLottoNumbers);
    }

    public BonusNumber inputBonusLottoNumber(Lotto winningLotto) {
        System.out.println(INPUT_WINNING_BONUS_NUMBER);
        String winningBonusNumber = Console.readLine();
        bonusNumberIsDigitExceptionCheck(winningBonusNumber);
        BonusNumber bonusNumber = new BonusNumber(winningBonusNumber);
        bonusNumberDuplicateExceptionCheck(winningLotto, bonusNumber);
        return bonusNumber;
    }

    private void moneyStartLetterIsNotZeroExceptionCheck(String moneyForLottos) {
        if(moneyForLottos.charAt(0) == ZERO) {
            throw new IllegalArgumentException(MONEY_START_NUMBER_IS_NOT_ZERO_EXCEPTION_MESSAGE);
        }
    }

    private void bonusNumberDuplicateExceptionCheck(Lotto winningLotto, BonusNumber bonusNumber) {
        boolean duplicateCheckResult = winningLotto.contains(bonusNumber);
        if (duplicateCheckResult) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private void bonusNumberIsDigitExceptionCheck(String winningBonusNumber) {
        boolean winnerBonusNumberIsDigitCheckResult = numberIsDigitCheck(winningBonusNumber);
        if (!winnerBonusNumberIsDigitCheckResult) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_DIGIT_EXCEPTION_MESSAGE);
        }
    }

    private boolean numberIsDigitCheck(String number) {
        return number.chars()
                .mapToObj(i -> (char) i)
                .allMatch(Character::isDigit);
    }

    private void inputMoneyDivideLottoPriceExceptionCheck(String moneyForLottos) {
        if (Integer.parseInt(moneyForLottos) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_DIVIDE_LOTTO_PRICE_EXCEPTION_MESSAGE);
        }
    }

    private void inputMoneyIsDigitValidationExceptionCheck(String moneyForLottos) {
        boolean moneyIsDigitCheckResult = moneyIsDigitCheck(moneyForLottos);
        if (!moneyIsDigitCheckResult) {
            throw new IllegalArgumentException(MONEY_IS_DIGIT_VALIDATION_EXCEPTION_MESSAGE);
        }
    }

    private boolean moneyIsDigitCheck(String moneyForLottos) {
        return numberIsDigitCheck(moneyForLottos);
    }

    private void winningLottoNumbersIsDigitExceptionCheck(String[] winningNumbers) {
        boolean winningLottoNumbersIsDigitResult = winningLottoNumbersIsDigitCheck(winningNumbers);
        if (!winningLottoNumbersIsDigitResult) {
            throw new IllegalArgumentException(WINNING_LOTTO_NUMBERS_IS_DIGIT_EXCEPTION_MESSAGE);
        }
    }

    private boolean winningLottoNumbersIsDigitCheck(String[] winningNumbers) {
        boolean AllLottoNumbersIsDigit = false;
        for (String winningNumber : winningNumbers) {
            AllLottoNumbersIsDigit = winningNumber.chars()
                    .mapToObj(i -> (char) i)
                    .allMatch(Character::isDigit);
        }
        return AllLottoNumbersIsDigit;
    }

    private Lotto getWinningLotto(String[] winningNumbers) {
        return new Lotto(Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }
}
