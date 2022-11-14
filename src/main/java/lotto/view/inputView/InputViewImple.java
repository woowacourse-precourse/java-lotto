package lotto.view.inputView;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.util.InputUtil;

import java.util.List;

public class InputViewImple implements InputView {

    @Override
    public Integer inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    @Override
    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return InputUtil.convertStringSplitToList(Console.readLine());
    }

    @Override
    public Integer inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
