package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.ConstVariable;
import lotto.util.ValidationUtil;

import java.util.List;

public class InputView {

    public static int getGeneratedLottoCount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        ValidationUtil.isValidAmount(amount);
        int count = Integer.parseInt(amount) / ConstVariable.STANDARD.getValue();
        System.out.println(count + "개를 구매했습니다.");
        return count;
    }

    public static List<Integer> getWinLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winNumbers = Console.readLine();
        return ValidationUtil.isValidWinNumbers(winNumbers);
    }

    public static int getWinBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
