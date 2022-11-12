package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Purchase;

public class Play {
    private static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String CHECK_MESSAGE = "개를 구매했습니다.";
    private static final String INPUT_WINNING_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_MESSAGE = "당첨 통계\n" +"---";
    private static final String RATE_MESSAGE = "총 수익률은 %f%입니다.";

    private Purchase purchase = new Purchase();

    public void startPlay(){
        System.out.println(START_MESSAGE);

        String amount = Console.readLine();
        int total = purchase.calculateAmount(amount);

        System.out.println("\n"+total+CHECK_MESSAGE);







    }


}
