package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoUserNumber {
    List<List<Integer>> LottoRandomNumbers = new ArrayList<>();

    public List<List<Integer>> createRandomNumber(long ticket) {
        for (int i = 0; i < ticket; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            LottoRandomNumbers.add(numbers);
        }
        return LottoRandomNumbers;
    }
}
