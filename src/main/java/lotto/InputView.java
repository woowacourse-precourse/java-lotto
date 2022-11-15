package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Util.toInt;


public class InputView {

    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return toInt(readLine());
    }


}
