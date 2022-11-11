package lotto;

public enum Message {

    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_LOTTERY_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASE("개를 구매했습니다."),
    CORRECT_THREE("3개 일치 (5,000원) - "),
    CORRECT_FOUR("4개 일치 (50,000원) - "),
    CORRECT_FIVE("5개 일치 (1,500,000원) - "),
    CORRECT_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    CORRECT_SIX("6개 일치 (2,000,000,000원) - "),
    ERROR("[ERROR]"),
    ERROR_INPUT_NUMBER("숫자를 입력해야 합니다."),
    ERROR_INPUT_1000("1000원 단위로 입력해야 합니다."),
    ERROR_INPUT_SIX("숫자를 여섯개 입력해야 합니다."),
    ERROR_INPUT_DUPLICATE("중복되지 않은 숫자를 입력해야 합니다."),
    ERROR_INPUT_RANGE("1부터 45사이의 숫자를 입력해야 합니다.");


    final String msg;

    Message(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }

    void printError() {
        System.out.println(Message.ERROR + " " + this.msg);
    }

    void printResult(long count) {
        System.out.println(this.msg + count + "개");
    }
}
