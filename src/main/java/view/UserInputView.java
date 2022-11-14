package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.BonusNumber;
import lotto.Lotto;
import lotto.PurchaseMoney;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputView {
    static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요";
    static final String INPUT_BONUS = "보너스 번호를 입력해 주세요";

    public static PurchaseMoney getPurchaseMoney() {
        System.out.println(INPUT_MONEY);
        String purchaseMoney = Console.readLine();

        try {
            return new PurchaseMoney(Integer.parseInt(purchaseMoney));
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구매하시는 금액은 숫자만 입력하셔야 합니다.");
        }

    }

    public static Lotto getWinningLottoNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        String winNumber = Console.readLine();
        try {
            List<Integer> winLottoNumber = Arrays.stream(winNumber.split(",")).map(Integer::parseInt).collect(Collectors.toList());
            return new Lotto(winLottoNumber);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하지 않으셨습니다.");
        }
    }

    public static BonusNumber getBonusLottoNumber() {
        System.out.println(INPUT_BONUS);
        String bonusNumber = Console.readLine();
        return new BonusNumber(bonusNumber);
    }
}
