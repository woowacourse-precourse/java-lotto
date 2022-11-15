package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbers {

    public List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
        Collections.sort(randomNumbers);
        return randomNumbers;

    }
}