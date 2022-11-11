package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoNumbersGenerator {
    private static final int MAX_LEN = 6;

    public List<Integer> generateLottoNumbers(final int startValue, final int endValue) {
        return getRandomNumbers(startValue, endValue);
    }

    public List<Integer> getRandomNumbers(final int startValue, final int endValue) {
        List<Integer> randomNumbers = new ArrayList<>();
        int randomNumber;

        while (randomNumbers.size() < MAX_LEN) {
            randomNumber = Randoms.pickNumberInRange(startValue, endValue);
            if(!randomNumbers.contains(randomNumber)){
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers ;
    }
}
