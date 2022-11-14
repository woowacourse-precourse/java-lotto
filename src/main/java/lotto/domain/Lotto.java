package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.IntConstant;
import lotto.constant.StringConstant;
import lotto.validation.IntegerValidation;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto() {
        List<Integer> randomCreateLotto = Randoms.pickUniqueNumbersInRange(
                IntConstant.LOTTO_NUMBER_BIGGER_THAN.getValue(),
                IntConstant.LOTTO_NUMBER_SMALLER_THAN.getValue(), IntConstant.LOTTO_NUMBER_COUNT.getValue());
        this.numbers = new ArrayList<>(randomCreateLotto);
        Collections.sort(numbers);
    }

    public Lotto(List<Integer> numbers) {
        isLottoLength(numbers);
        isLottoBetween(numbers);
        isLottoNumberOverlapping(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현

    @Override
    public String toString() {
        return this.numbers.toString();
    }
    public boolean contains(int number) {
        return this.numbers.contains(number);
    }
    private void isLottoLength(List<Integer> numbers) {
        if (!(IntegerValidation.isBetween(numbers.size(), IntConstant.LOTTO_NUMBER_COUNT.getValue(),
                IntConstant.LOTTO_NUMBER_COUNT.getValue()))) {
            throw new IllegalArgumentException(StringConstant.LOTTO_INPUT_LENGTH_ERROR_MESSAGE.getMessage());
        }
    }

    private void isLottoBetween(List<Integer> numbers) {
        if (!(numbers.stream().allMatch(
                number -> IntegerValidation.isBetween(number, IntConstant.LOTTO_NUMBER_BIGGER_THAN.getValue(),
                        IntConstant.LOTTO_NUMBER_SMALLER_THAN.getValue())))) {
            throw new IllegalArgumentException(StringConstant.LOTTO_INPUT_NUMBER_BETWEEN_ERROR_MESSAGE.getMessage());
        }
    }

    private void isLottoNumberOverlapping(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(StringConstant.LOTTO_INPUT_NUMBER_OVERLAPPING_ERROR_MESSAGE.getMessage());
        }
    }

    public int[] compareToWinningLotto(WinningLotto winningLotto) {
        int[] result = new int[2];
        for (int lottoNum : this.numbers) {
            result[0] += winningLotto.countLotto(lottoNum);
            result[1] += winningLotto.countBonusLotto(lottoNum);
        }
        return result;
    }


}
