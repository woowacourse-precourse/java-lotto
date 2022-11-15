package lotto.message;

public enum PrintResult {

    RESULT_FIFTH("3개 일치 (5,000원) - "),
    RESULT_FORTH("4개 일치 (50,000원) - "),
    RESULT_THIRD("5개 일치 (1,500,000원) - "),
    RESULT_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RESULT_FIRST("6개 일치 (2,000,000,000원) - "),
    RESULT_INCOME("총 수익률은 ");

    private String statement;

    PrintResult(String printResult) {
        this.statement = printResult;
    }

    public void printResult (int ranking) {
        System.out.println(this.statement + ranking + "개");
    }

    public void printIncome (double income) {
        System.out.println(this.statement + income + "%입니다.");
    }
}
