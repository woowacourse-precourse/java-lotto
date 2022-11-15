package service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    final static int MAX_LOTTO_LENGTH = 6;
    public List<List<Integer>> saveUserRandomNumbers(int count, List<List<Integer>> userRandomNumbers) {
        for (int i = 1; i <= count; i++) {
            userRandomNumbers.add(makeUserRandomNumbers());
        }
        return userRandomNumbers;
    }

    public List<Integer> makeUserRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

    public List<Integer> changeTypeOfWinningNumbers(String[] tempWinningNumbers) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < MAX_LOTTO_LENGTH; i++) {
            numbers.add(Integer.parseInt(tempWinningNumbers[i]));
        }

        return numbers;
    }
}
