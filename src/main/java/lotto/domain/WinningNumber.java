package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    public static final String COMMA = ",";
    public static final int LOTTO_NUMBER = 0;
    public static final int BONUS_NUMBER = 1;

    private final WinningNumberValidator validator = new WinningNumberValidator();
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(List<String> winnerNumber) {
        validator.validateLottoNumber(winnerNumber.get(LOTTO_NUMBER));
        this.numbers = creatNumbers(winnerNumber.get(LOTTO_NUMBER));
        validator.validateBonusNumber(winnerNumber.get(BONUS_NUMBER), numbers);
        this.bonusNumber = Integer.parseInt(winnerNumber.get(BONUS_NUMBER));
    }

    private List<Integer> creatNumbers(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(COMMA))
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
