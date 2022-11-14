package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import static Constant.ErrorMessage.UNITS_THOUSAND;

public class Purchase {

    Integer purchaseAmount;
    Utils util = new Utils();

    public List<Lotto> lottoPurchase() {
        this.purchaseAmount = util.isNumeric(Console.readLine());
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(UNITS_THOUSAND);
        }

        LottoGenerator lottoGenerator = new LottoGenerator(purchaseAmount);
        return lottoGenerator.generateLotto();
    }
}
