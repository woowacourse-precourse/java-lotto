package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int SIZE = 6;

    public List<Lotto> issueLottos(int lottoNum) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            addLotto(lottos);
        }

        return null;
    }

    private void addLotto(List<Lotto> lottos) {
        List<Integer> numbers = getRandomNumbers();
        lottos.add(new Lotto(numbers));
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, SIZE);
        Collections.sort(numbers);
        return numbers;
    }

}
