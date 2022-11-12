package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.enums.ConstantInteger;

import java.util.*;
import java.util.stream.IntStream;

public class LottoRandomPeek {
    private final List<Lotto> randomLottos;

    public LottoRandomPeek(int countLotto) {
        randomLottos = new ArrayList<>();
        for (int peekIndex = 0; peekIndex < countLotto; peekIndex++) {
            drawLotto();
        }
    }

    public void drawLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                ConstantInteger.START_NUMBER.getValue(), ConstantInteger.LAST_NUMBER.getValue(), ConstantInteger.LOTTO_SIZE.getValue());
        randomLottos.add(new Lotto(sortList(randomNumbers)));
    }

    private List<Integer> sortList(List<Integer> randomNumbers) {
        for (int i = 0; i < randomNumbers.size() - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < randomNumbers.size(); j++) {
                if (randomNumbers.get(idx) > randomNumbers.get(j)) {
                    idx = j;
                }
            }
            if (i != idx) {
                int tmp = randomNumbers.get(idx);
                randomNumbers.set(idx, randomNumbers.get(i));
                randomNumbers.set(i, tmp);
            }
        }
        return randomNumbers;
    }

    public List<Lotto> getRandomLottos() {
        return randomLottos;
    }

}
