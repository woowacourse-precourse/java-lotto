package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class LottoProgram {
    public static void init() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmout = Console.readLine();
        String purchaseRegex = "^[1-9]*000$";
        if (!Pattern.matches(purchaseRegex, purchaseAmout)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요");
        }
        int purchaseAmoutCash = Integer.parseInt(purchaseAmout);
    }
}
