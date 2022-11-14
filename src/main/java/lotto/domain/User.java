package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final LottoManager lottoManager = new LottoManager();

    public void start() {
        int price;
        int count;
        List<Lotto> lottos;

        System.out.println("구입금액을 입력해 주세요.");
        price = lottoManager.inputPrice();

        count = lottoManager.setCount(price);
        System.out.println("\n" + count + "개를 구매했습니다.");

        lottos = lottoManager.createLottos(count);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

    }
}
