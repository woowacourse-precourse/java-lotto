package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Random {
    private final List<Integer> randomNumbers;

    public Random(){
        randomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    public List<Integer> getRandomNumbers(){
        return randomNumbers;
    }
}
