package lotto.lottoGenerator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.PrimitiveIterator;

import static lotto.constants.Constants.*;

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
            if(i < 1 || i > END_NUMBER_OF_LOTTO) {
                throw new IllegalArgumentException("[ERROR] 랜덤생성된 로또번호에 에러가 발생했습니다.");
            }
            if(isVisited[i]) {
                throw new IllegalArgumentException("[ERROR] 랜덤생성된 로또번호에 에러가 발생했습니다.");
            }
            isVisited[i] = true;
        }
    }
}
