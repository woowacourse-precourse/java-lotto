package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static java.lang.Integer.parseInt;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUM = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUM = "보너스 번호를 입력해 주세요.";

    public int getInputAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        int inputAmount = 0;
        try {
            inputAmount = parseInt(readLine());
        } catch (NumberFormatException exception) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return validationInputAmount(inputAmount);
    }

    private int validationInputAmount(int inputAmount) {
        //TODO: validation 구현 필요
        return inputAmount;
    }

    public List<Integer> getWinningNums() {
        System.out.println(INPUT_WINNING_NUM);
        List<Integer> winningNums = new ArrayList<>();
        for (String winningNum : readLine().split(",")) {
            winningNums.add(Integer.parseInt(winningNum));
        }
        return winningNums;
    }

    public int getBonusNum() {
        System.out.println(INPUT_BONUS_NUM);
        //TODO : validation 추가 필요
        return parseInt(readLine());
    }
}
