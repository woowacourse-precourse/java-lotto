package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Result;

public class LottoGame {
    private static LottoMachine lottoMachine;
    private LottoGame() {
    }

    public static LottoGame init() {
        lottoMachine = LottoMachine.init();
        return new LottoGame();
    }

    public void start() {
        try {
            Integer moneyEntered = Input.inputMoney();
            validateInputMoney(moneyEntered);
            int lottoCnt = moneyEntered / 1000;
            List<Lotto> lottoes = lottoMachine.makeLottoes(lottoCnt);
            Output.showLottoesPurchased(lottoes);
            lottoMachine.makeWinningNumber(Input.inputWinningNumber());
            lottoMachine.makeBonusNumber(Input.inputBonusNumber());

            Result result = lottoMachine.returnResult(lottoes);
            Output.showResult(result);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
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
