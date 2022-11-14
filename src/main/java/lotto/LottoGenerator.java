package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> createLottos(int money) {
        List<Lotto> lottoList = new ArrayList<>();
        int amount = getAmountOfLottos(money);

        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(createRandomNumbers());
            lottoList.add(lotto);
        }

        printLottos(lottoList);

        return lottoList;
    }

    private int getAmountOfLottos(int money) {
        return money / 1000;
    }

    private List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    private void printLottos(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {

    }
}
