package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Purchase {

    Integer purchaseAmount;

    public List<Lotto> lottoPurchase() {
        this.purchaseAmount = numericAmount(Console.readLine());
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        LottoGenerator lottoGenerator = new LottoGenerator(purchaseAmount);
        return lottoGenerator.generateLotto();
    }

    private Integer numericAmount(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력 가능합니다.");
        }
    }
}
