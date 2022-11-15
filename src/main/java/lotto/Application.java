package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.compareLottoNumber.CompareRandomAndUserNumber;
import lotto.buyLotto.BuyLotto;
import lotto.buyLotto.Lotto;

public class Application {
    private final static BuyLotto buyLotto = new BuyLotto();
    private final static CompareRandomAndUserNumber compareRandomAndUserNumber = new CompareRandomAndUserNumber();
    public static void main(String[] args) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        int[] prizeNumbers = new int[6];
        int[] result = new int[5];
        int money = 0;

        try {
            money = buyLotto.buyLotto(lottoNumbers);

            compareRandomAndUserNumber.compareAndReturnResult(money, prizeNumbers, result, lottoNumbers);
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

}
