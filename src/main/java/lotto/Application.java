package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoInput;
import lotto.domain.LottoLogic;

import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String ERROR_MESSAGE = "[ERROR]";

        UI lottoUI = new UI();
        String lottoMoneyInput = lottoUI.LottoInputMoney();

        LottoLogic lottoLogic = new LottoLogic();



//        try {
//            lottoLogic.logic(lottoMoneyInput);
//        } catch (IllegalArgumentException exception) {
//
//            System.out.println(ERROR_MESSAGE+exception.getMessage());
////            throw new IllegalArgumentException();
//        }

        lottoLogic.logic(lottoMoneyInput);

        lottoUI.LottoCountOutput();
        lottoUI.PrintLottoNumber();

        lottoLogic.logicRank(lottoUI.WinningNumber(), lottoUI.BonusNumber());
        lottoUI.WinningTotal();

    }




}
