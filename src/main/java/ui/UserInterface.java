package ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInterface {
    private static final int PRICE_UNIT = 1000;
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_SUCCESS_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해주세요.";

    public static int enterPurchasePrice() {
        System.out.println(PURCHASE_PRICE_INPUT_MESSAGE);
        String price = Console.readLine();
        System.out.println();

        return Integer.parseInt(price) / PRICE_UNIT;
    }

    public static void printPurchaseResult(int lottoCount, List<Lotto> lottos) {
        System.out.println(lottoCount + PURCHASE_SUCCESS_MESSAGE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    public static WinningLotto enterWinningLotto() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        String winningNumbers = Console.readLine();
        System.out.println();

        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String bonusNumber = Console.readLine();
        System.out.println();

        // 나중에 입력 값을 검증하여 에러를 잡는 코드가 추가돼야 함
        return new WinningLotto(
                Arrays.stream(winningNumbers.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()),
                Integer.parseInt(bonusNumber));
    }
}
