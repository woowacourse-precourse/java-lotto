package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.User;

public class Application {

    public static void main(String[] args) {
        LottoMachine machine = new LottoMachine();
        User user = new User();

        try {
            lottoGame(machine, user);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void lottoGame(LottoMachine machine, User user) {
        machine.getInputMoney();
        machine.createLottoNumber();

        user.inputWinningNumber();
        user.inputBonusNumber();

        machine.printLottos();
        machine.getResult(user.getWinningNumber(), user.getBonusNumber());
        machine.printResult();
    }
}
