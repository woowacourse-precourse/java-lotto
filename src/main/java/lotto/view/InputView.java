package lotto.view;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUM = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUM = "보너스 번호를 입력해 주세요.";

    public int getInputAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return validateOnlyNaturalNumber(readLine());
    }

    public List<Integer> getWinningNums() {
        System.out.println(INPUT_WINNING_NUM);
        List<Integer> winningNums = new ArrayList<>();
        for (String winningNum : readLine().split(",")) {
            winningNums.add(validateOnlyNaturalNumber(winningNum));
        }
        return winningNums;
    }

    public int getBonusNum() {
        System.out.println(INPUT_BONUS_NUM);
        return validateOnlyNaturalNumber(readLine());
    }

    private int validateOnlyNaturalNumber(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("자연수만 입력해주세요!");
        }
        return parseInt(input);
    }
}
