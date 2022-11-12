package lotto;

import static lotto.Constant.LOTTO_PRICE;

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
            List<Lotto> lottoes = buyLottoes();
            determineWinningNumberAndBonusNumber();
            Result result = lottoMachine.returnResult(lottoes);
            Output.showResult(result);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private void determineWinningNumberAndBonusNumber() {
        lottoMachine.makeWinningNumber(Input.inputWinningNumber());
        lottoMachine.makeBonusNumber(Input.inputBonusNumber());
    }

    private List<Lotto> buyLottoes() {
        Integer moneyEntered = Input.inputMoney();
        validateInputMoney(moneyEntered);
        List<Lotto> lottoes = lottoMachine.makeLottoes(moneyEntered / LOTTO_PRICE);
        Output.showLottoesPurchased(lottoes);
        return lottoes;
    }

    protected void validateInputMoney(Integer moneyEntered) {
        if(moneyEntered % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("1000으로 나누어 떨어지는 숫자를 입력하세요");
        }
        if (moneyEntered < LOTTO_PRICE) {
            throw new IllegalArgumentException("1장 이상은 로또를 구매해야 합니다");
        }
    }
}
