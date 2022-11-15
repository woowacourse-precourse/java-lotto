package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Generator {
    private final int lottoCount;

    public Generator(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public List<List<Integer>> createLotto() {
        List<List<Integer>> playerLotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            playerLotto.add(lotto);
        }
        printLotto(playerLotto);
        return playerLotto;
    }

    private void printLotto(List<List<Integer>> playerLotto) {
        System.out.println(lottoCount + Constant.BUY_TEXT);
        for (List<Integer> lotto : playerLotto) {
            System.out.println(lotto);
        }
        System.out.println();
    }
}
