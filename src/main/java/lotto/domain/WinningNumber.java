package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.utils.MessageFormatUtil;

public class WinningNumber {
    public static final int LOTTO_NUMBER = 0;
    public static final int BONUS_NUMBER = 1;

    private final WinningNumberValidator validator = new WinningNumberValidator();
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(List<String> winnerNumber) {
        validator.validateLottoNumber(winnerNumber.get(LOTTO_NUMBER));
        this.numbers = createNumbers(winnerNumber.get(LOTTO_NUMBER));
        validator.validateBonusNumber(winnerNumber.get(BONUS_NUMBER), numbers);
        this.bonusNumber = Integer.parseInt(winnerNumber.get(BONUS_NUMBER));
    }

    private List<Integer> createNumbers(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(MessageFormatUtil.COMMA))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
