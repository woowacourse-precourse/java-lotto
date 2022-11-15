package lotto.program;

import lotto.domain.LottoOfAnswer;
import lotto.domain.LottoOfUser;

public class MainProgram {
    private final ConsoleProgram consoleProgram;
    private final BusinessProgram businessProgram;

    public MainProgram() {
        consoleProgram = new ConsoleProgram();
        businessProgram = new BusinessProgram();
    }

    public void run() {
        int money = consoleProgram.requestMoney();

        LottoOfUser userLotto = businessProgram.generateUserLotto(money);
        businessProgram.printUserLotto(userLotto);

        LottoOfAnswer answerLotto = consoleProgram.requestAnswerLottoWithBonusNumber();
        businessProgram.printUserLottoResults(userLotto,answerLotto);
    }
}
