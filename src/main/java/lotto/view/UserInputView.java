package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public enum UserInputView {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String inputMessage;

    UserInputView(String inputMessage){
        this.inputMessage = inputMessage;
    }

    public static String userInput(){
        return Console.readLine();
    }

    public String getInputMessage() {
        return inputMessage;
    }
}
