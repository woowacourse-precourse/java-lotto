package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyLotto {
    private final int money;
    public int lottoCount;

    public BuyLotto(int money) {
        validate(money);
        this.money = money;
        lottoCount = money / 1000;
    }

    private void validate(int money) {
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 1000원 단위로 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public List<List<Integer>> getLottoSet (int lottoCount) {
        List<List<Integer>> lottoSet = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++) {
            List<Integer> lottoNumbers = new ArrayList<>(getLottoNumbers());
            Collections.sort(lottoNumbers);
            lottoSet.add(lottoNumbers);
        }
        return lottoSet;
    }

    public List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
