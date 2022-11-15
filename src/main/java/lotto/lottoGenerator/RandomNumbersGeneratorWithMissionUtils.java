package lotto.lottoGenerator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.constants.ExceptionMessage.NOT_VALID_LOTTO_GENERATED;
import static lotto.constants.LottoConstants.*;

public class RandomNumbersGeneratorWithMissionUtils implements RandomNumbersGenerator{
    @Override
    public List<Integer> generateRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER_OF_LOTTO, END_NUMBER_OF_LOTTO, NUMBER_OF_PICKED);
        validate(numbers);
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        boolean[] isVisited = new boolean[END_NUMBER_OF_LOTTO + 1];
        for(int i : numbers) {
            if(i < 1 || i > END_NUMBER_OF_LOTTO || isVisited[i]) {
                throw new IllegalArgumentException(NOT_VALID_LOTTO_GENERATED);
            }
            isVisited[i] = true;
        }
    }
}
