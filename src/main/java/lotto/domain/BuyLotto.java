package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyLotto {

    public InPutSystem inPutSystem = new InPutSystem();

    public static final int LOTTO_PRICE = 1000;

    public List<List<Integer>> lottoList = new ArrayList<>();
    public static int cntLotto = 0;


    public BuyLotto() {
        int price = Integer.parseInt(inputSystem());
        calculateLotto(price);
    }

    public void calculateLotto(int price) {
        cntLotto = price / LOTTO_PRICE;

        // 예외 처리 필요 ( 1000 단위 )
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PrintMessages.ERROR_MONEY_RANGE.getMessage());
        }
        if (price < 1000) {
            throw new IllegalArgumentException(PrintMessages.ERROR_MONEY_MIN.getMessage());
        }

    }

    public void GenerateLottoNumber() {
        for (int i = 0; i < cntLotto; i++) {
            List<Integer> randomList = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(randomList);
            Lotto lotto = new Lotto(randomList);
            lottoList.add(lotto.getNumbers());
        }
    }
}
