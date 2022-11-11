package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        sizeCheck(numbers);
        this.numbers = numbers;
    }

    private static List<Integer> sizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 수로 이루어져 있습니다.");
        }
        return numbers;
    }

    private static List<List<Integer>> makeLottos(Integer money) {
        List<List<Integer>> lottos = new ArrayList<>();

        for (int ticket = 0; ticket < money / 1000; ticket++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lotto);
            lottos.add(lotto);
            lotto = new ArrayList<>();
        }
        return lottos;
    }

}