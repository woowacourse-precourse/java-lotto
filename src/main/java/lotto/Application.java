package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.User;

public class Application {
    static private LottoMachine machine = new LottoMachine();
    static private User user = new User();

    public static void main(String[] args) {
        try {
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
