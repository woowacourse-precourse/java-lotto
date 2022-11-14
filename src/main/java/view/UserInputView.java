package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputView {
    static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요";
    static final String INPUT_BONUS ="보너스 번호를 입력해 주세요";

    private Integer getPurchaseMoney(){
        System.out.println(INPUT_MONEY);
        String purchaseMoney = Console.readLine();
        return Integer.parseInt(purchaseMoney);
    }

    private Lotto getWinningLottoNumber(){
        System.out.println(INPUT_WINNING_NUMBER);
        String winNumber = Console.readLine();
        List<Integer> winLottoNumber = Arrays.stream(winNumber.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        return new Lotto(winLottoNumber);
    }

    private Integer getBonusLottoNumber(){
        System.out.println(INPUT_BONUS);
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }
}
