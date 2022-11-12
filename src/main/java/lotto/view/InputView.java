package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Console.*;

public class InputView {
    public String inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
}
