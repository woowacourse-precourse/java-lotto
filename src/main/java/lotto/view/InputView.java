package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String TYPE_WRONG = "[ERROR] 숫자만 입력해주세요";


    public static int inputAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        return convertToInt(Console.readLine());
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        }catch (Exception e){
            throw new IllegalArgumentException(TYPE_WRONG);
        }
    }
}
