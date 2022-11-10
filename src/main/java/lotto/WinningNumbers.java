package lotto;

import camp.nextstep.edu.missionutils.Console;

public class WinningNumbers {
    private enum GuideMessageType {
        WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        GuideMessageType(String message) {
            this.message = message;
        }
    }
    
    private String setNumber() {
        return Console.readLine();
    }

    private void printGuideMessage(String message) {
        System.out.println(message);
    }
}
