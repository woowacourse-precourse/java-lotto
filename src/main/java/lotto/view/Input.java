package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.caculation.Money;
import lotto.reward.Numbers;
import lotto.reward.RewardNumbers;
import org.junit.platform.commons.util.StringUtils;

public class Input {

    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return new Money(checkNull(input));
    }

    public static RewardNumbers inputRewardNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return new RewardNumbers(checkNull(input));
    }

    public static Numbers inputBonusNumber() {
        System.out.println("보너스 번호를 입력.");
        String input = Console.readLine();
        return Numbers.of(checkNull(input));
    }

    private static String checkNull(String input) {
        if (StringUtils.isBlank(input)) {
            throw new NullPointerException("[ERROR] 입력 값이 비어있습니다.");
        }
        return input;
    }
}
