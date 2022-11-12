package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUM = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUM = "보너스 번호를 입력해 주세요.";

    public int getInputAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        int inputAmount = parseInt(Console.readLine());
        return validationInputAmount(inputAmount);
    }

    private int validationInputAmount(int inputAmount) {
        return inputAmount;
    }

    public List<Integer> getWinningNums() {
        System.out.println(INPUT_WINNING_NUM);
        String read = Console.readLine();
        String[] strings = read.split(",");
        List<Integer> list = new ArrayList<>();
        for (String string : strings) {
            list.add(Integer.parseInt(string));
        }
        return list;
    }

    public int getBonusNum() {
        System.out.println(INPUT_BONUS_NUM);
        return parseInt(Console.readLine());
    }
}
