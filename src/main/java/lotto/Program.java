package lotto;

import java.util.List;

public class Program {
    private final ConsoleProgram consoleProgram;
    private final BusinessProgram businessProgram;

    public Program() {
        consoleProgram = new ConsoleProgram();
        businessProgram = new BusinessProgram();
    }

    public void run() {
        int money = consoleProgram.requestMoney();
        List<Lotto> userLotto = businessProgram.generateUserLotto(money);
        LottoOfAnswer answerLotto = consoleProgram.requestAnswerLottoWithBonusNumber();
    }
}
