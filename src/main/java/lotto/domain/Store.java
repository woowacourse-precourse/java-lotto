package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.config.Constant.LOTTO_NUMBER_CAPACITY;

public class Store {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    List<List<Integer>> numbers = new ArrayList<>();

    public void drawNumber(int hasLotto) {
        int i;
        for (i = 0; i < hasLotto; i++) {
            numbers.add(Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_CAPACITY));
            numbers.get(i).stream().sorted().collect(Collectors.toList());
        }
    }

    public List<List<Integer>> getNumbers() {
        return numbers;
    }

}
