package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputUserMoney {

    public static int InputMoney() throws IllegalArgumentException{
        System.out.println("구입금액을 입력해 주세요.");
        String InputUserMoney = readLine();

        if(!JudgmentInputNumberGenerator.JudgmentInputNumber(InputUserMoney)) {
            //숫자로 이루어져있지 않을 경우 예외 처리
            System.out.println("[ERROR] 구매금액은 숫자여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 구매금액은 숫자여야 합니다.");
        }
        return Integer.parseInt(InputUserMoney);
    }
}
