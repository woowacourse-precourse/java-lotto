package lotto;

import lotto.logic.LottoLogic;
import lotto.logic.UserLogic;
import lotto.process.Process;
import lotto.screen.ConsoleInput;
import lotto.screen.Input;
import lotto.screen.Output;

public class GameContext {
    public LottoGame lottoGame() {
        LottoGame lottoGame = LottoGame.getInstance();
        lottoGame.setInput(input());
        lottoGame.setOutput(output());
        lottoGame.setProcess(process());
        return lottoGame;
    }

    public Process process() {
        Process process = Process.getInstance();
        process.setLottoLogic(lottoLogic());
        process.setUserLogic(userLogic());
        return process;
    }

    public Input input() {
        return ConsoleInput.getInstance();
    }

    public Output output() {
        return Output.getInstance();
    }

    public LottoLogic lottoLogic() {
        return LottoLogic.getInstance();
    }

    public UserLogic userLogic() {
        return UserLogic.getInstance();
    }
}
