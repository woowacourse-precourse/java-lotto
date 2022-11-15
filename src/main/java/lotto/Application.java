package lotto;


import lotto.domain.LottoMachine;
import lotto.domain.User;
import lotto.model.Lotto;
import lotto.view.Printer;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Printer.inputBuyAmount();
            LottoMachine machine = new LottoMachine();
            User user = new User();

            machine.getInputMoney();
            machine.createLottoNumber();

            user.inputWinningNumber();
            user.inputBonusNumber();

            machine.printLottos();
            machine.getResult(user.getWinningNumber(), user.getBonusNumber());

            machine.printResult();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
