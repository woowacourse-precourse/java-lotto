package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Util;

public class InputView {

    public static int getView() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        Util.isValidAmount(amount);
        int count = Integer.parseInt(amount) / 1000;
        System.out.println(count + "개를 구매했습니다.");
        return count;
    }
}
