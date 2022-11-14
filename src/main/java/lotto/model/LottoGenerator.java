package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.valid.Lotto;

public class LottoGenerator {

    private static final int LOTTO_PRICE = 1000;
    private ArrayList<List<Integer>> lotteries;

    public void generateLotto(String money) {
        int lottoCount = Integer.parseInt(money) / LOTTO_PRICE;
        List<Integer> lottoNumber;
        ArrayList<List<Integer>> lotteries = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().collect(
                Collectors.toList());
            Lotto lotto = new Lotto(lottoNumber);
            lotteries.add(lottoNumber);
        }
        this.lotteries = lotteries;
    }

    public ArrayList<List<Integer>> getLotteries() {
        return lotteries;
    }

}
