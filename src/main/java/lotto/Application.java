package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Cashier;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumber;
import lotto.domain.User;

public class Application {
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        User user = new User();
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
        List<Lotto> purchasedLottos = new ArrayList<>();

        int userValue = user.payPrice();
        int lottoAmount = cashier.sellLotto(userValue);

        for (int i = 0; i < lottoAmount; i++) {
            Lotto purchasedLotto = new Lotto();
            System.out.println(purchasedLotto.getNumbers());
            purchasedLottos.add(purchasedLotto);
        }

        lottoWinningNumber.generateLottoNumber();
        Lotto targetWinningLotto = new Lotto(lottoWinningNumber.getNumbers());
        BonusNumber bonusNumber = new BonusNumber(targetWinningLotto.getNumbers());

    }
}
