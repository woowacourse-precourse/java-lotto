package lotto;

import java.util.List;

public class GameStarter {
    private static final String MONEY_INPUT = "구입금액을 입력해 주세요.";
    private static final String WIN_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT = "보너스 번호를 입력해 주세요.";

    Inputer inputer = new Inputer();
    Generator generator = new Generator();
    Printer printer = new Printer();

    CompareHowManyCorrect compareHowManyCorrect = new CompareHowManyCorrect();
    Calculater calculater = new Calculater();
    public void gameStart(){


        printer.printToDo(MONEY_INPUT);
        int userInputMoney = inputer.inputMoney();

        List<List<Integer>> userLottoNumberList = generator.generateRandomLottoNumber(userInputMoney);
        printer.printUserLottoNumber(userLottoNumberList);

        printer.printToDo(WIN_INPUT);
        List<Integer> lottoWinNumber = inputer.createLottoWinNumber();

        printer.printToDo(BONUS_INPUT);
        int bonusNumber = inputer.inputLottoBonusNumber();

        List<Integer> amountCorrectList = compareHowManyCorrect.correctNumberList(userLottoNumberList,lottoWinNumber,bonusNumber);
        int revenue = calculater.caculateRevenue(amountCorrectList);
        printer.printWinList(amountCorrectList);
        printer.printRevenuePercent(userInputMoney,revenue);
    }
}
