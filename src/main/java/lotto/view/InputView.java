package lotto.view;

import static lotto.constant.Constants.InputMessage.INPUT_BONUS_NUMBER;
import static lotto.constant.Constants.InputMessage.INPUT_MONEY;
import static lotto.constant.Constants.InputMessage.INPUT_WINNING_NUMBERS;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.utils.InputUtil;

public class InputView {
    public static final String DELIMITER = ",";

    public static Money inputMoney() {
        System.out.println(INPUT_MONEY);
        Money money = new Money(InputUtil.readNumber());
        System.out.println();
        return money;
    }

    public static Lotto inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        List<Integer> numbers = InputUtil.readNumbersByDelimiter(DELIMITER);
        System.out.println();
        return new Lotto(toLottoNumbers(numbers));
    }

    public static LottoNumber inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        int bonusNumber = InputUtil.readNumber();
        System.out.println();
        return new LottoNumber(bonusNumber);
    }

    private static List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}