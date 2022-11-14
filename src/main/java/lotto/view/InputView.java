package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static java.lang.Integer.parseInt;
import static java.lang.String.*;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUM = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUM = "보너스 번호를 입력해 주세요.";

    public int getInputAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        String inputAmount = validationInputAmount(readLine());
        return parseInt(inputAmount);
    }

    public List<Integer> getWinningNums() {
        System.out.println(INPUT_WINNING_NUM);
        List<Integer> winningNums = new ArrayList<>();
        for (String winningNum : readLine().split(",")) {
            winningNums.add(Integer.parseInt(winningNum));
        }
        return winningNums;
    }

    private String validationInputAmount(String inputAmount) {
        if (!inputAmount.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("금액은 자연수만 입력해주세요!");
        }
        return inputAmount;
    }

    public int getBonusNum() {
        System.out.println(INPUT_BONUS_NUM);
        //TODO : validation 추가 필요
        return parseInt(readLine());
    }
}
