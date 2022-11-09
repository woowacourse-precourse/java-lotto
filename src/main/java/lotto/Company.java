package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private static final String INVALID_BONUS_INPUT =
            "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private static final String NUMBER_DELIMETER = ",";
    private List<Integer> winNumbers;
    private Integer bonusNumber;

    public void inputWinNumbers() {
        String input = Console.readLine();
        validateWinNumbers(input);
        winNumbers = new ArrayList<>();
        for (String number : input.split(NUMBER_DELIMETER)) {
            winNumbers.add(Integer.parseInt(number));
        }
    }

    private void validateWinNumbers(String winNumbers) {
        String[] numbers = winNumbers.split(NUMBER_DELIMETER);
        try {
            List<Integer> lotto = new ArrayList<>();
            for (String number : numbers) {
                lotto.add(Integer.parseInt(number));
            }
            new Lotto(lotto);
        } catch (NumberFormatException ignored) {
            LottoError.illegalArgumentException(Shop.INVALID_STRING_INPUT);
        }
    }

    public void inputBonusNumber() {
        try {
            Integer input = Integer.parseInt(Console.readLine());
            validateBonusNumber(input);
            this.bonusNumber = input;
        } catch (NumberFormatException ignored) {
            LottoError.illegalArgumentException(Shop.INVALID_STRING_INPUT);
        }
    }

    private void validateBonusNumber(Integer number) {
        if (winNumbers.contains(number)) {
            LottoError.illegalArgumentException(INVALID_BONUS_INPUT);
        }
        if (number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER) {
            LottoError.illegalArgumentException(Lotto.INVALID_RANGE_INPUT);
        }
    }
}
