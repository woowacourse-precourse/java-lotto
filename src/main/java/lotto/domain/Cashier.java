package lotto.domain;

import java.util.List;
import lotto.ui.UserInterface;

public class Cashier {
    private List<Lotto> lottos;
    private Account account;

    public void buyLottos() {
        String inputMoneyRaw = UserInterface.getInputMoney();
        int inputMoney = convertStringToInt(inputMoneyRaw);
        this.lottos = LottoMachine.publish(inputMoney);
    }

    public void saveResultInAccount() {
        this.account.saveResult(lottos);
    }

    public void getResultInAccount() {
        this.account.getResult();
    }

    private int convertStringToInt(String numberRaw) {
        return Integer.parseInt(numberRaw);
    }

}
