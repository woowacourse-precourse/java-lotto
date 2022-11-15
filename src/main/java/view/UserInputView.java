package view;

import camp.nextstep.edu.missionutils.Console;
import domain.BonusNumber;
import domain.Lotto;
import domain.PurchaseMoney;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputView {
    static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요";
    static final String INPUT_BONUS = "보너스 번호를 입력해 주세요";
    static final String ERROR_MESSAGE_FOR_PURCHASE_PRICE_IS_NUMBER = "구매하시는 금액은 숫자만 입력하셔야 합니다.";
    static final String ERROR_MESSAGE_FOR_WINNING_NUMBER = "당첨번호는 오직 숫자와 ,로 구분하여 입력하셔야 합니다.";

    public static PurchaseMoney getPurchaseMoney() {
        System.out.println(INPUT_MONEY);
        String purchaseMoney = Console.readLine();

        try {
            return new PurchaseMoney(Integer.parseInt(purchaseMoney));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_PURCHASE_PRICE_IS_NUMBER);
        }

    }

    public static Lotto getWinningLottoNumber() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER);
        String winNumber = Console.readLine();
        try {
            List<Integer> winLottoNumber = Arrays.stream(winNumber.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new Lotto(winLottoNumber);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_WINNING_NUMBER);
        }
    }

    public static BonusNumber getBonusLottoNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS);
        String bonusNumber = Console.readLine();
        System.out.println();
        return new BonusNumber(bonusNumber);
    }
}
