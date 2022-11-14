package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.enums.IntEnum;

import java.util.*;

public class LottoRandomPeek {
    private final List<Lotto> randomLottos;

    public LottoRandomPeek() {
        randomLottos = new ArrayList<>();
    }
    public void generateRandom(int countLotto){
        for (int peekIndex = 0; peekIndex < countLotto; peekIndex++) {
            drawLotto();
        }
    }

    public List<Integer> drawLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                IntEnum.START_NUMBER.getValue(), IntEnum.LAST_NUMBER.getValue(), IntEnum.LOTTO_SIZE.getValue());
        randomLottos.add(new Lotto(randomNumbers));
        return randomNumbers;
    }
    public void addLotto(List<Integer> addRottoList){
        randomLottos.add(new Lotto(sortList(addRottoList)));
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
