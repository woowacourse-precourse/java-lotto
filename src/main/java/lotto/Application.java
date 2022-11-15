package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        try {
            lottoController.inputUserMoney();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }
        lottoController.printLottoNumber();
        lottoController.inputWinningNumber();
        lottoController.inputBonusNumber();
        lottoController.printStatistics();
        lottoController.printRevenue();

    }
}
