package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private ArrayList<List<Integer>> lotteries;

    public void generateLotto(String money) {
        int lottoCount = Integer.parseInt(money) / 1000;
        List<Integer> lottoNumber;
        ArrayList<List<Integer>> lotteries = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumber);
            lotteries.add(lottoNumber);
        }
        this.lotteries = lotteries;
    }

    public ArrayList<List<Integer>> getLotteries() {
        return lotteries;
    }

}
