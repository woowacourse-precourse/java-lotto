package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer>[] drawLottoNumbers(int lottoCount) {
        List<Integer>[] lottoNumbers = new ArrayList[lottoCount];
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers[i] = new ArrayList<>();
            lottoNumbers[i] = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers[i]);
        }
        return lottoNumbers;
    }

    public void compareLotto(List<Integer> numbers, List<Integer>[] lottoNumbers, int bonusNumber) {
        int count;
        boolean bonus;
        for (int i = 0; i < lottoNumbers.length; i++) {
            for (int j = 0; j < numbers.size(); j++) {
                count = compareNumbers(numbers.get(j), lottoNumbers[i]);
            }
        }
    }
    public int compareNumbers(int numbers, List<Integer> lottoNumbers) {
        int count = 0;
        for (int i = 0; i < lottoNumbers.size(); i++) {
            if (numbers == lottoNumbers.get(i)) {
                count++;
            }
        }
        return count;
    }
    public boolean compareBonusNumber(List<Integer> lottoNumbers, int bonus) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            if (bonus == lottoNumbers.get(i)) {
                return true;
            }
        }
        return false;
    }
}
