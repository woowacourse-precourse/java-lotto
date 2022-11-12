package lotto.setting;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.lotto.Lotto;
import java.util.List;

public enum LottoSetting {
    NORMAL(45, 6);

    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER;
    private final int NUMBER_OF_DRAWS;

    LottoSetting(int maxNumber, int numberOfDraws) {
        this.MAX_NUMBER = maxNumber;
        this.NUMBER_OF_DRAWS = numberOfDraws;
    }

    public boolean isValidNumbers(List<Integer> numbers) {
        return isSizeMatched(numbers) && isNumberInRange(numbers) && isNotOverlapped(numbers);
    }

    private boolean isSizeMatched(List<Integer> numbers) {
        return numbers.size() == NUMBER_OF_DRAWS;
    }

    private boolean isNumberInRange(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> MIN_NUMBER <= number && number <= MAX_NUMBER)
                .reduce(true, Boolean::logicalAnd);
    }

    private boolean isNotOverlapped(List<Integer> numbers) {
        return numbers.stream().distinct().count() == NUMBER_OF_DRAWS;
    }

    public Lotto createAutoLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_OF_DRAWS);
        return new Lotto(randomNumbers,this);
    }

}
