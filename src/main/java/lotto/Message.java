package lotto;

public enum Message {

    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_LOTTERY_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ERROR("[ERROR]");


    final String msg;

    Message(String msg) {
        this.msg = msg;
    }
}
