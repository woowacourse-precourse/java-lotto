package lotto;

import lotto.UI.ConsoleView;
import lotto.UI.InputMoney;
import lotto.UI.InputWinningAndBonusNumbers;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGame lottoGame = new LottoGame();
            lottoGame.start();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 사용자 입력입니다.");
        }
    }
}
