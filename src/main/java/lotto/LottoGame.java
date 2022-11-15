package lotto;

import view.Input;
import model.Data;
import view.MessagePrint;

import java.util.Collections;

public class LottoGame {
    public void playLottoGame() {

        try {
            Exception exception = new Exception();
            Data data = new Data();
            MessagePrint message = new MessagePrint();

            message.printInputAmount();

            data.purchaseAmount = Input.inputNumber();
            exception.checkPurchaseAmount(data.purchaseAmount);

            data.makeNumberOfLotto();
            message.printLottoCount(data.numberOfLotto);

            data.initializeUserLotto();

            for (int i = 0; i < data.numberOfLotto; i++) {
                data.userLotto[i].addAll(Input.makeRandomNumber());
                Collections.sort(data.userLotto[i]);
            }

            message.printUserLottoNumber(data.userLotto, data.numberOfLotto);


            message.printInputWinningNumber();


            data.winningNumber = Input.inputNumber();
            data.winningNumberSplit = data.winningNumber.split(",");
            for (int i = 0; i < data.winningNumberSplit.length; i++) {
                exception.winningNumberRange(data.winningNumberSplit[i]);
            }
            data.makeWinningLottoNumber();

            new Lotto(data.winningLottoNumber);


            message.printInputBonusNumber();
            data.BonusNumber = Input.inputNumber();
            exception.checkBonusNumber(data.BonusNumber);
            exception.checkBonusNumberOverLap(data.BonusNumber, data.winningLottoNumber);
            message.printStatistics();

            data.initializeWinningStatistics();

            for (int i = 0; i < data.userLotto.length; i++) {
                data.makeWinningStatistics(data.userLotto[i], data.checkLottoNumber(data.userLotto[i]));
            }

            message.printWinningStatistics(data.winningStatistics);

            data.makeYield();

            message.printYield(data.yield);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            return;
        }
    }

}
