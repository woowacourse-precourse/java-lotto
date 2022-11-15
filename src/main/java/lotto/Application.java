package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Bank;
import lotto.domain.BonusNumber;
import lotto.domain.Cashier;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumber;
import lotto.domain.PrizeCount;
import lotto.domain.User;

public class Application {
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        User user = new User();
        List<Lotto> purchasedLottos = new ArrayList<>();
        cashier.sellLotto(user.payPrice(), purchasedLottos);
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
        lottoWinningNumber.generateLottoNumber();
        Lotto targetWinningLotto = new Lotto(lottoWinningNumber.getNumbers());
        int bonusNumber = new BonusNumber(targetWinningLotto.getNumbers()).getBonusNumber();
        Bank bank = new Bank(purchasedLottos, targetWinningLotto, cashier.getLottoAmount());
        bank.returnLottoResult(bonusNumber);
    }
}
