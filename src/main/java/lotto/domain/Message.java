package lotto.domain;

public enum Message {
    Buy_Lotto("개를 구매했습니다."),
    Input_Cost("구입금액을 입력해 주세요."),
    Input_Lotto("당첨번호를 입력해 주세요."),
    Input_Bonus("보너스번호를 입력해 주세요."),
    Print_Statistic("\n당첨 통계\n---\n"),
    Exception_NotCorrectSize("[ERROR] 6개의 숫자를 입력해주세요."),
    Exception_NotInteger("[ERROR] 숫자를 입력해주세요."),
    Exception_Not1000unit("[ERROR] 1000원 단위만 입력 가능합니다."),
    Exception_NegativeNum("[ERROR] 양수를 입력해주세요."),
    Exception_NotInRange("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    Exception_DuplicateNum("[ERROR] 중복되지 않는 숫자만 입력 가능합니다.");
    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
