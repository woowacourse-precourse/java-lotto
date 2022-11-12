package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String inputPurchaseNumber = "구입금액을 입력해 주세요.";
    private final String inputWinningNumbers = "당첨 번호를 입력해 주세요.";
    private final String inputBonusNumber = "보너스 번호를 입력해 주세요.";

    // 구입 금액
    public String getPurchaseAmount() {
        return getUserInput(inputPurchaseNumber);
    }
    public String getBonusNumber() {
        return getUserInput(inputBonusNumber);
    }

    public String getWinningNumbers() {
        return getUserInput(inputWinningNumbers);
    }

    private String getUserInput(String output) {
        System.out.println(output); // 상수로 변경하여 문자 출력
        return Console.readLine();
    }
}
