package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        Lotto lotto = lottoManager.issue();
        UI ui = new UI();
        ui.printLotto(lotto);
    }

    public int inputCustomerMoney() {
        return 0;
    }

    public List<Integer> inputWinningNumber() {
        return null;
    }

    public int inputBonusNumber() {
        return 0;
    }
}
