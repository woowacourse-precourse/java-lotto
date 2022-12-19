package Views;

import camp.nextstep.edu.missionutils.Console;

import static Views.InputView.INPUT_VIEW;

public class OutputView {
    public static final OutputView OUTPUT_VIEW = new OutputView();

    public void PrintPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void PrintCountPurchasingLotto() {
        System.out.println(INPUT_VIEW.InputCash(Console.readLine()) + "개를 구매했습니다.");
    }
}
