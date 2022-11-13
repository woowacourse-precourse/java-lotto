package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BuyLotto {

    public static final int LOTTO_PRICE = 1000;

    public List<List<Integer>> lottoList = new ArrayList<>();
    public int cntLotto = 0;

    public BuyLotto() {
        int price = Integer.parseInt(inputSystem());
        calculateLotto(price);
    }

    public void calculateLotto(int price) {
        cntLotto = price / LOTTO_PRICE;

        // 예외 처리 필요 ( 1000 단위 )
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void GenerateLottoNumber() {
        for (int i = 0; i < cntLotto; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoList.add(lotto.getNumbers());
        }
    }

    public void showLottos() {
        for (List<Integer> list : lottoList) {
            System.out.println(list);
        }
    }

    public String inputSystem() {
        return Console.readLine();
    }
}
