package lotto;

import java.util.List;

public class GameStarter {

    Inputer inputer = new Inputer();
    Generator generator = new Generator();
    Printer printer = new Printer();

    CompareHowManyCorrect compareHowManyCorrect = new CompareHowManyCorrect();
    Calculater calculater = new Calculater();
    public void gameStart(){

        int userInputMoney = inputer.inputMoney();
        List<List<Integer>> userLottoNumberList = generator.generateRandomLottoNumber(userInputMoney);
        printer.printUserLottoNumber(userLottoNumberList);

        List<Integer> lottoWinNumber = inputer.createLottoWinNumber();
        int bonusNumber = inputer.inputLottoBonusNumber();

        List<Integer> amountCorrectList = compareHowManyCorrect.correctNumberList(userLottoNumberList,lottoWinNumber,bonusNumber);
        int revenue = calculater.caculateRevenue(amountCorrectList);
        printer.printWinList(amountCorrectList);
        printer.printRevenuePercent(userInputMoney,revenue);
    }
}
