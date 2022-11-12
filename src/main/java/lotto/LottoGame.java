package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;

public class LottoGame {
    private static LottoMachine lottoMachine;
    private LottoGame() {
    }

    public static LottoGame init() {
        lottoMachine = LottoMachine.init();
        return new LottoGame();
    }

    public void start() {
        Integer moneyEntered = Input.inputMoney();
        validateInputMoney(moneyEntered);
        int lottoCnt = moneyEntered / 1000;
        List<Lotto> lottoes = lottoMachine.makeLottoes(lottoCnt);
        Output.showLottoesPurchased(lottoes);
        Input.inputWinningNumber();
    }

    protected void validateInputMoney(Integer moneyEntered) {
        if(moneyEntered % 1000 != 0) {
            throw new IllegalArgumentException("1000으로 나누어 떨어지는 숫자를 입력하세요");
        }
        if (moneyEntered < 1000) {
            throw new IllegalArgumentException("1000 이상의 숫자를 입력하세요");
        }
    }
}
