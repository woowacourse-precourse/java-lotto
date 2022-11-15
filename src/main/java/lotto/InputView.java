package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Util.toInt;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return toInt(readLine());
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String s : readLine().split(",")) {
            winningNumbers.add(toInt(s));
        }
        return winningNumbers;
    }


}
