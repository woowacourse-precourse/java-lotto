package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.constance.LottoConstance.*;
import static lotto.exception.InputException.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNotDuplicate(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현

    public static Lotto create() {
        return new Lotto(createRandomNumbers());
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
    public boolean isContainsBonusNumber(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    public List<Integer> deleteWinLottoNumbers(List<Integer> winLottoNumbers) {
        List<Integer> tempLottoGetNumbers = new ArrayList<>(this.numbers);
        tempLottoGetNumbers.retainAll(winLottoNumbers);
        return tempLottoGetNumbers;
    }

    private static List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER, NUMBER_LENGTH);
        return new ArrayList<>(randomNumbers);
    }
}
