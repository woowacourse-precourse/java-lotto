package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.User;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
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
