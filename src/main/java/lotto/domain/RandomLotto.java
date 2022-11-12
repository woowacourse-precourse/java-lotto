package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomLotto {
    public List<List<Integer>> randomGenerator(int tickets) {
        List<List<Integer>> randomLotto = new ArrayList<>();
        List<Integer> oneTicket = new ArrayList<>();

        for (int j = 0; j < tickets; j++) {
            for (int i = 0; i < 1; i++) {
                oneTicket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            }
            randomLotto.add(oneTicket);
        }

        for (List<Integer> randomNumber : randomLotto) {
            Collections.sort(randomNumber);
        }

        return randomLotto;
    }
}