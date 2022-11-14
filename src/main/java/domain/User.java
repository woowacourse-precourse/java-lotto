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
    }

    public void inputBuyPrice() {
        buyPrice = Integer.parseInt(readLine());
    }
}
