package lotto.domain;

import lotto.model.Lotto;
import lotto.view.Printer;

import java.util.List;

public class Executor {
    private boolean flag = true;
    public void startGame() {
        Printer.inputBuyAmount();
        LottoMachine machine = new LottoMachine();
        machine.getInputMoney();
        List<Lotto> lottos = machine.createLottoNumber();

        User user = new User(lottos);
        user.inputWinningNumber();
        user.inputBonusNumber();

        machine.printLottos();
        machine.getResult(user.getWinningNumber(), user.getBonusNumber());

        machine.printResult();
    }
}
