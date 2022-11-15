package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private final String MESSAGE_TO_GET_MONEY = "구입금액을 입력해 주세요.";
    private final String MESSAGE_TO_GET_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private final String MESSAGE_TO_GET_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public int getMoney() {
        System.out.println(MESSAGE_TO_GET_MONEY);
        String input = Console.readLine().trim();

        if (!isNumber(input)) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 돈을 넣어주세요.");
        }

        return Integer.parseInt(input);
    }
    public List<Integer> getWinningNumbers() {
        System.out.println(MESSAGE_TO_GET_WINNING_NUMBER);
        String input = Console.readLine().trim(); //띄어쓰기 고려

        return castToList(input);
    }
    public int getBonusNumbers() {
        System.out.println(MESSAGE_TO_GET_BONUS_NUMBER);
        String input = Console.readLine().trim(); //띄어쓰기 고려

        isNumber(input);
        return Integer.parseInt(input);
    }


}