package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String TYPE_WRONG = "[ERROR] 숫자만 입력해주세요";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        return convertToInt(SCANNER.nextLine());
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        }catch (Exception e){
            throw new IllegalArgumentException(TYPE_WRONG);
        }
    }
}
