package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Purchase {

    Integer purchaseAmount;

    public List<Lotto> lottoPurchase() {
        // 로또 구입 금액 입력
        this.purchaseAmount = Integer.parseInt(Console.readLine());
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        // 로또 생성기
        LottoGenerator lottoGenerator = new LottoGenerator(purchaseAmount);
        return lottoGenerator.generateLotto();
    }
}
