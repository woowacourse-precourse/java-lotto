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

    public WinningNumber(List<String> winningNumber) {
        validator.validateLottoNumber(winningNumber.get(LOTTO_NUMBER));
        this.numbers = createNumbers(winningNumber.get(LOTTO_NUMBER));
        validator.validateBonusNumber(winningNumber.get(BONUS_NUMBER), numbers);
        this.bonusNumber = Integer.parseInt(winningNumber.get(BONUS_NUMBER));
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
