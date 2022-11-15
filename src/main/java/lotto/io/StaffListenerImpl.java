package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class StaffListenerImpl implements StaffListener {
    private static final String receiveMoneyMessage = "구입금액을 입력해 주세요.";
    @Override
    public String receiveMoney() {
        System.out.println(receiveMoneyMessage);
        String money = Console.readLine();
        return money;
    }
}
