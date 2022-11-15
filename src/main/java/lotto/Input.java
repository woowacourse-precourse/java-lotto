package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Input {

    private static final String WINNER_NUMBERS_SPLIT_REGEX = ",";

    public static LottoMoney inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return readMoney();
    }

    public static Lotto inputWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return new Lotto(Arrays.stream(splitReadLine())
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList()));
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static String[] splitReadLine() {
        return Console.readLine().split(WINNER_NUMBERS_SPLIT_REGEX);
    }

    private static LottoMoney readMoney() {
        return new LottoMoney(Console.readLine());
    }

}
