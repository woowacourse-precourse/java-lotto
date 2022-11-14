package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputUserMoney {

    public static int InputMoney() throws IllegalArgumentException{
        System.out.println("구입금액을 입력해 주세요.");
        String InputUserMoney = readLine();
        if(!JudgmentInputNumberGenerator.JudgmentInputNumber(InputUserMoney)) {
            throw new IllegalArgumentException("[ERROR] 잘못 입력하였습니다");
        }
        return Integer.parseInt(InputUserMoney);
    }
}
