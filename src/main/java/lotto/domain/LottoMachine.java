package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoMachine {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int SIZE = 6;

    public List<Lotto> issueLottos(int lottoNum) {
        List<Integer> numbers = getRandomNumbers();

        return null;
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, SIZE);
    }
}
