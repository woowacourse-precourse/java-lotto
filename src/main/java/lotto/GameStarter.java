package lotto;

import java.util.List;

public class GameStarter {
    private static final String MONEY_INPUT = "구입금액을 입력해 주세요.";
    private static final String WIN_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT = "보너스 번호를 입력해 주세요.";

    Inputer inputer = new Inputer();
    LottoNumberGenerator generator = new LottoNumberGenerator();
    Printer printer = new Printer();

    CorrectNumberCounter correctNumberCounter = new CorrectNumberCounter();
    RevenueCalculater revenueCalculater = new RevenueCalculater();

    private List<List<Integer>> userLottoNumberList;
    private int userInputMoney;

    private List<Integer> lottoWinNumber;
    private int bonusNumber;


    public void gameStart() {
        moneyInputLottoOutput();

        lottoNumberInput();

        revenueOutput();
    }

    public void moneyInputLottoOutput(){
        printer.printToDo(MONEY_INPUT);
        this.userInputMoney = inputer.inputMoney();

        this.userLottoNumberList = generator.generateLottoNumber(userInputMoney);
        printer.printUserLottoNumber(userLottoNumberList);
    }

    public void lottoNumberInput(){
        printer.printToDo(WIN_INPUT);
        this.lottoWinNumber = inputer.createLottoWinNumber();

        printer.printToDo(BONUS_INPUT);
        this.bonusNumber = inputer.inputLottoBonusNumber();
    }

    public void revenueOutput(){
        List<Integer> amountCorrectList = correctNumberCounter.correctNumberList(userLottoNumberList, lottoWinNumber,
                bonusNumber);
        int revenue = revenueCalculater.caculateRevenue(amountCorrectList);

        printer.printWinList(amountCorrectList);
        printer.printRevenuePercent(userInputMoney, revenue);
    }

}
