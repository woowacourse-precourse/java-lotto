package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputUserMoney {

    public static int InputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String InputUserMoney = readLine();
        int UserMoney = Integer.parseInt(InputUserMoney);

        return UserMoney;
    }
}
