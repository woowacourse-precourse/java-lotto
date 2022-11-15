package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoMarket {
    private static final int LOTTOPRICE = 1000;
    private int purchasePrice;
    private int purchaseLottoNum;
    private List<Lotto> lottos;

    public void inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String s = Console.readLine();

        // validate 검사 (입력형식, 금액이 1000으로 나눠어 떨어지지 않는 경우)
        this.purchasePrice = Integer.parseInt(s);
        this.purchaseLottoNum = purchasePrice / LOTTOPRICE;
    }

    public void publishLotto() {
    }

    public void printLottoInfo() {
    }
}
