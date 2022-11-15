package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final String INPUT_ERROR_MESSAGE ="[ERROR] 돈을 넣어주세요.";
    private static final String MESSAGE_TO_GET_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_TO_GET_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_TO_GET_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public int getMoney() {
        System.out.println(MESSAGE_TO_GET_MONEY);
        String input = Console.readLine().trim(); // 띄어쓰기 고려

        if (!isNumber(input)) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
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

    //서비스로직 1.입력값이 숫자인지 확인
    public boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
        return true;
    }

    // 서비스 로직2. 문자열을 List<Integer>로 형변환 하기
    public List<Integer> castToList(String input) {
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : input.split(",")) {
            isNumber(number.trim());
            winningNumbers.add(Integer.valueOf(number.trim()));
        }

        return winningNumbers;
    }
}
