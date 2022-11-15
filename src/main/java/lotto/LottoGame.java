package lotto;

import view.Input;
import model.Data;
import view.MessagePrint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame{

    public void playLottoGame() {

        Data data = new Data();
        MessagePrint message = new MessagePrint();

        message.printInputAmount();
        data.purchaseAmount= Input.inputNumber();
        data.getNumberOfLotto();

        message.printLottoCount(data.numberOfLotto);

        data.initializeUserLotto();

        for(int i=0;i<data.numberOfLotto;i++){
            data.userLotto[i].addAll(Input.getRandomNumber());
            Collections.sort(data.userLotto[i]);
            new Lotto(data.userLotto[i]);
        }

        message.printUserLotto(data.userLotto, data.numberOfLotto);


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

        for (int i = 0; i < data.userLotto.length; i++) {
            int checkLotto = data.checkLottoNumber(data.userLotto[i]);
            data.map(data.userLotto[i], checkLotto);
        }

        message.printCheckLotto(data.Win);

        data.getYield();


        message.printYield(data.yield);

    }

}
