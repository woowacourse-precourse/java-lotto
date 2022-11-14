package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.enums.IntEnum;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static lotto.enums.IntEnum.*;

public class LottoRandomPeek {
    private final List<Lotto> randomLottos = new ArrayList<>();

    public void drawLotto() {
        List<Integer> randomNumbers = pickUniqueNumbersInRange(
                START_NUMBER.getValue(), LAST_NUMBER.getValue(), LOTTO_SIZE.getValue());
        randomLottos.add(new Lotto(randomNumbers));
    }

    public void generateRandom(int countLotto) {
        for (int peekIndex = 0; peekIndex < countLotto; peekIndex++) {
            drawLotto();
        }
    }

    public List<Lotto> getRandomLottos() {
        return randomLottos;
    }
}
