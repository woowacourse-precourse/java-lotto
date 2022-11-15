package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Prize {
    static final String ENTER_MONEY = "구매금액을 입력해 주세요.";
    static final String PURCHASE_LOTTO = "%d개를 구매했습니다.";
    static final int LOTTO_COUNT = 1000;

    public Prize() {
        Integer lottoCount = purchaseLotto();
        System.out.printf(PURCHASE_LOTTO, lottoCount);
    }

    public Integer purchaseLotto(){
        System.out.println(ENTER_MONEY);
        String inputMoney = Console.readLine();
        Integer money = Integer.valueOf(inputMoney);
        int lottoCount = money / LOTTO_COUNT;
        return lottoCount;
    }
}
