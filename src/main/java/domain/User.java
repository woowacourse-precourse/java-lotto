package domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private LottoGame lottoGame;
    private int buyPrice;

    public void startLottoGame() {
        lottoGame = new LottoGame();
        System.out.println("구입금액을 입력해 주세요.");
        inputBuyPrice();
        System.out.println();

        System.out.println((buyPrice / 1000) + "개를 구매했습니다.");
        lottoGame.createLotto(buyPrice/1000);
        lottoGame.printLotteries(buyPrice/1000);
        System.out.println();
    }
    public void inputBuyPrice() {
        buyPrice = Integer.parseInt(readLine());
    }
}
