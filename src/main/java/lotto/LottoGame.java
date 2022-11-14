package lotto;


import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public void playLottoGame() {

        Number number = new Number();
        MessagePrint message = new MessagePrint();

        message.printInputAmount();
        number.inputNumber(Message.AMOUNT.getMessage());

        int Amount = Integer.parseInt(number.purchaseAmount);
        int n = Amount / 1000;

        message.printLottoCount(n);

        List<Integer>[] userLotto = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            userLotto[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n; i++) {
            number.getRandomNumber();
            userLotto[i].addAll(number.randomNumbers);
        }

        message.printUserLotto(userLotto, n);


        message.printInputWinningNumber();

        number.inputNumber(Message.WINNING.getMessage());

        List<Integer> winningLottoNumber = new ArrayList<>();

        String[] winningNumberSplit = number.winningNumber.split(",");
        for (int i = 0; i < winningNumberSplit.length; i++) {
            winningLottoNumber.add(Integer.valueOf(winningNumberSplit[i]));
        }

        message.printBonusNumber();
        number.inputNumber(Message.BONUSNUMBER.getMessage());

        message.printSTATISTICS();

        number.initializeMap();

        for (int i = 0; i < userLotto.length; i++) {
            int checkLotto = number.checkLottoNumber(userLotto[i], winningLottoNumber);
            number.map(userLotto[i], checkLotto);
        }

        message.printCheckLotto(number.Win);

        double yield = number.getYield(Amount);


        message.printYield(yield);


    }

}
