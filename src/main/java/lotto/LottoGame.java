package lotto;

import lotto.domain.User;
import lotto.process.Process;
import lotto.screen.IOResolve;
import lotto.screen.Input;
import lotto.screen.Output;

import java.util.List;

public class LottoGame {
    private static LottoGame lottoGame = new LottoGame();
    private Process process;
    private Input input;
    private Output output;

    private LottoGame() {
    }

    public static LottoGame getInstance() {
        return lottoGame;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public void start() {
        try {
            process.init();
            play();
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
        }
    }

    private void play() {
        // 예수금 입력
        Integer money = (Integer) input.input("구입금액을 입력해 주세요.\n",
                IOResolve::toInteger);
        User user = process.createUser(money);

        //로또번호 생성
        Integer lottoCounts = process.makeLottoNumbers(user);
        output.printMessage("%d개를 구매했습니다.\n", lottoCounts);

        // 로또 번호 출력
        output.output(() -> process.lottoNumbers(user));

        //당첨번호 입력
        List<Integer> winningNumbers = (List<Integer>) input.input("당첨 번호를 입력해 주세요.\n",
                IOResolve::splitIntegers);

        //보너스번호 입력
        Integer bonusNumber = (Integer) input.input("보너스 번호를 입력해 주세요.\n",
                IOResolve::toInteger);

        // 번호 비교
        process.compareNumbers(user, winningNumbers, bonusNumber);

        //당첨 통계
        output.output(() -> process.sumUp(user));
    }
}
