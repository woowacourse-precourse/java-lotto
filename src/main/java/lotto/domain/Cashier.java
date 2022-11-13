package lotto.domain;

import java.util.List;
import lotto.ui.UserInterface;

public class Cashier {
    private List<Lotto> lottos;
    private Account account;

    public void buyLottos() {
        int inputMoney = UserInterface.getInputMoney();
        this.lottos = LottoMachine.publish(inputMoney);
    }

    public void saveResultInAccount() {
        this.account.saveResult(lottos);
    }
}
