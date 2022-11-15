package lotto.view;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String Lotto_Purchase_Amount_Message = "구입금액을 입력해 주세요.";
    private static final String Winning_Number_Input_Message = "당첨 번호를 입력해 주세요.";
    private static final String Bonus_Number_Input_Message = "보너스 번호를 입력해 주세요.";
    public static int inputLottoPurchaseAmount() {
        System.out.println(Lotto_Purchase_Amount_Message);
        String lottoPurchaseAmount = Console.readLine();
        lottoPurchaseAmountException(lottoPurchaseAmount);
        return Integer.parseInt(lottoPurchaseAmount);
    }

    public static void lottoPurchaseAmountException(String lottoPurchaseAmount) {
        for (int i = 0; i < lottoPurchaseAmount.length(); i++) {
            if (!Character.isDigit(lottoPurchaseAmount.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력했습니다.");
            }
        }
    }

    public static String inputWinningNumber() {
        System.out.println();
        System.out.println(Winning_Number_Input_Message);
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        System.out.println();
        System.out.println(Bonus_Number_Input_Message);
        return Integer.parseInt(Console.readLine());
    }
}
