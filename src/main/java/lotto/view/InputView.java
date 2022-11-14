package lotto.view;
import camp.nextstep.edu.missionutils.Console;
public class InputView {
    private static final String Lotto_Purchase_Amount_Message = "구입금액을 입력해 주세요.";
    public static int inputLottoPurchaseAmount() {
        System.out.println(Lotto_Purchase_Amount_Message);
        return Integer.parseInt(Console.readLine());
    }
}
