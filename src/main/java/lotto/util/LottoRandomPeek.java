package lotto.util;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static lotto.enums.LottoEum.*;

public class LottoRandomPeek {
    private final List<Lotto> randomLottos = new ArrayList<>();

    public void drawLotto() {
        List<Integer> randomNumbers = pickUniqueNumbersInRange(
                START_NUMBER.getValue(), LAST_NUMBER.getValue(), LOTTO_SIZE.getValue());
        randomLottos.add(new Lotto(sortList(randomNumbers)));
    }

    public void generateRandom(int countLotto) {
        for (int peekIndex = 0; peekIndex < countLotto; peekIndex++) {
            drawLotto();
        }
    }

    public List<Lotto> getRandomLottos() {
        return randomLottos;
    }

    private List<Integer> sortList(List<Integer> randomNumbers) {
        List<Integer> newRandomNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(newRandomNumbers);
        return newRandomNumbers;
    }

    @Override
    public String toString() {
        StringBuilder printLottos = new StringBuilder();
        printLottos.append(randomLottos.size()+"개를 구매했습니다.\n");
        for(Lotto nowLotto : randomLottos){
            printLottos.append(nowLotto.toString()+"\n");
        }
        return printLottos.toString();
    }
}
