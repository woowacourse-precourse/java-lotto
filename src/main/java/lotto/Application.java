package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.WinNumbers;

public class Application {
    public static void main(String[] args) {
        try {
            BuyLotto buyLotto = new BuyLotto();
            buyLotto.showLottosNumber();
            buyLotto.showLottosList();

            System.out.println("당첨 번호를 입력해 주세요.");
            WinNumbers winNumbers = new WinNumbers(Console.readLine());

            LottoResult lottoResult = new LottoResult(buyLotto, winNumbers);
            lottoResult.showWinStats();
            lottoResult.showProfitRate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
