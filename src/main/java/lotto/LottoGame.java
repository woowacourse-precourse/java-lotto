package lotto;

import view.Input;
import model.Data;
import view.MessagePrint;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public void playLottoGame() {

        Data data = new Data();
        MessagePrint message = new MessagePrint();

        message.printInputAmount();
        data.purchaseAmount= Input.inputNumber();
        data.getNumberOfLotto();

        message.printLottoCount(data.numberOfLotto);

        List<Integer>[] userLotto = new ArrayList[data.numberOfLotto];

        for (int i = 0; i < data.numberOfLotto; i++) {
            userLotto[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < data.numberOfLotto; i++) {
            userLotto[i].addAll(Input.getRandomNumber());
            new Lotto(userLotto[i]);
        }

        message.printUserLotto(userLotto, data.numberOfLotto);


        message.printInputWinningNumber();


        data.winningNumber=Input.inputNumber();


        String[] winningNumberSplit = data.winningNumber.split(",");
        for (int i = 0; i < winningNumberSplit.length; i++) {
            data.winningLottoNumber.add(Integer.valueOf(winningNumberSplit[i]));
        }

        new Lotto(data.winningLottoNumber);


        message.printBonusNumber();
        data.BonusNumber=Input.inputNumber();

        message.printSTATISTICS();

        data.initializeMap();

        for (int i = 0; i < userLotto.length; i++) {
            int checkLotto = data.checkLottoNumber(userLotto[i]);
            data.map(userLotto[i], checkLotto);
        }

        message.printCheckLotto(data.Win);

        data.getYield();


        message.printYield(data.yield);

    }

}
