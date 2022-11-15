package lotto;

import lotto.view.LottoView;

public class Application {

    public static void main(String[] args) {
        try {
            LottoView view = new LottoView();
            view.addLotteries();
            view.printLotteries();
            view.addLuckyLotto();
            view.addBonusNumber();
            view.printStatsOfWin();
        } catch (IllegalArgumentException excepted) {
            // view에서 에러메세지에 대한 출력 처리를 수행한다.
        }
    }
}
