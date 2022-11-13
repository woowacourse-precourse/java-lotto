package lotto.program;

import java.util.List;
import lotto.vo.Lotto;
import lotto.vo.LottoOfAnswer;

public class MainProgram {
    private final ConsoleProgram consoleProgram;
    private final BusinessProgram businessProgram;

    public MainProgram() {
        consoleProgram = new ConsoleProgram();
        businessProgram = new BusinessProgram();
    }

    public void run() {
        int money = consoleProgram.requestMoney();
        List<Lotto> userLotto = businessProgram.generateUserLotto(money);
        LottoOfAnswer answerLotto = consoleProgram.requestAnswerLottoWithBonusNumber();
//        businessProgram.printUserLottoResults(userLotto,answerLotto);
    }
}
