package lotto.message;

public enum PrintInput {

    INPUT_BONUS("보너스 번호를 입력해주세요."),
    INPUT_MONEY("구입 금액을 입력해주세요."),
    INPUT_LOTTO("당첨 번호를 입력해주세요."),
    INPUT_NUMBER("개를 구매했습니다.");

    private String statement;
    PrintInput(String printResult) {
        this.statement = printResult;
    }

    public String printInput () {
        return this.statement;
    }
    public void print () {
        System.out.println(this.statement);
    }
}
