package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Amounts;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.util.ValidUtil;

import java.util.LinkedList;
import java.util.List;

public class Input {

    private final ValidUtil validUtil;

    public Input(ValidUtil validUtil) {
        this.validUtil = validUtil;
    }

    public Amounts inputPurchasingAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = validUtil.validNumber(Console.readLine());
        int amount = validUtil.validAmountUnit(Integer.parseInt(input));
        return new Amounts(amount);
    }

    public Lotto inputWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요.");
        String[] numbers = validUtil.validAllWinningNumber(Console.readLine());
        List<Integer> winningAndBonusNumber = new LinkedList<>();
        for (String number : numbers) {
            winningAndBonusNumber.add(Integer.parseInt(number));
        }

        validUtil.validateDuplication(winningAndBonusNumber);
        return new Lotto(winningAndBonusNumber);
    }

    public WinningNumber inputBonusNumber(Lotto lotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validUtil.validateNumberRange(input);


        return new WinningNumber(lotto, Integer.parseInt(input));
    }

}
