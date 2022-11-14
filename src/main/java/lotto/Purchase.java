package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import static Constant.ErrorMessage.NOT_INTEGER;
import static Constant.ErrorMessage.UNITS_THOUSAND;

public class Purchase {

    Integer purchaseAmount;

    public List<Lotto> lottoPurchase() {
        this.purchaseAmount = numericAmount(Console.readLine());
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(UNITS_THOUSAND);
        }

        LottoGenerator lottoGenerator = new LottoGenerator(purchaseAmount);
        return lottoGenerator.generateLotto();
    }

    private Integer numericAmount(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
    }
}
