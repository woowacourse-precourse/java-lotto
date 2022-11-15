package lotto.View;

import lotto.domain.*;

public class Game {
    private Screen screen = new Screen();
    private User user;
    private LottoAnswer lottoAnswer;
    private Calculator calculator;
    private Result result;

    public void start(){
        userSetting();
        computerSetting();
        printUserLotto();
        calculate();
        printResult();
    }

    public void userSetting(){
        user = new User(screen.readMoney());
        user.makeLottos();
    }

    public void computerSetting(){
        lottoAnswer = new LottoAnswer(screen.readLotto(), screen.readBonus());
    }

    public void printUserLotto(){
        screen.printLottoCount(user.getNumOfLotto());
        screen.printLottos(user.getLottos());
    }

    public void calculate(){
        result = new Result(user.getUserMoney());
        calculator = new Calculator();
        for (Lotto lotto : user.getLottos()) {
            calculator.clearCount();
            calculator.checkCount(lotto, lottoAnswer);
            result.checkRanks(calculator);
        }
        result.calcAllResult();
    }

    public void printResult(){
        screen.printResult(result);
    }



}