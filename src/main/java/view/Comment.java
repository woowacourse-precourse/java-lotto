package view;

public enum Comment {
    PRINT_INSERT_COIN("구매금액을 입력해 주세요."),
    PRINT_INSERT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    PRINT_ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요");


    private final String message;

    Comment(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
