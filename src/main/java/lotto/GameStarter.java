package lotto;

import java.util.List;

public class GameStarter {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WIN_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    private List<List<Integer>> userLottoNumberList;
    private int userInputMoney;


    private List<Integer> lottoWinNumber;
    private int bonusNumber;


    Inputer inputer = new Inputer();
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    Printer printer = new Printer();
    CorrectNumberCounter correctNumberCounter = new CorrectNumberCounter();
    RevenueCalculater revenueCalculater = new RevenueCalculater();



    public void gameStart() {
        moneyInputLottoOutput();

        lottoNumberInput();

        revenueOutput();
    }

    public void moneyInputLottoOutput() {

        printer.printToDo(MONEY_INPUT_MESSAGE);
        this.userInputMoney = inputer.inputMoney();

        this.userLottoNumberList = lottoNumberGenerator.generateLottoNumber(userInputMoney);

        printer.printUserLottoNumber(userLottoNumberList);
    }

    public void lottoNumberInput() {

        printer.printToDo(WIN_INPUT_MESSAGE);
        this.lottoWinNumber = inputer.createLottoWinNumber();

        printer.printToDo(BONUS_INPUT_MESSAGE);
        this.bonusNumber = inputer.inputLottoBonusNumber();
    }

    public void revenueOutput() {

        List<Integer> amountCorrectNumberList = correctNumberCounter.makeCorrectNumberAmountList(userLottoNumberList,
                lottoWinNumber, bonusNumber);
        int revenueMoney = revenueCalculater.caculateRevenue(amountCorrectNumberList);

        printer.printCorrectNumberAmountList(amountCorrectNumberList);

        printer.printRevenuePercent(userInputMoney, revenueMoney);
    }
}
