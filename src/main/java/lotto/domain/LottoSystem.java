package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class LottoSystem {
    private static int TICKET_PRICE = 1000;

    //구매금액
    public int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String lottoMoney = Console.readLine();
        return Integer.parseInt(lottoMoney);
    }
    //구매로또수량
    public void  purchaseLottoAmount() {
        int lottoAmount = purchaseAmount() / TICKET_PRICE;
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }
}
