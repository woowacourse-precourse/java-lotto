package lotto.Output;

public enum PrintOutput {
    BUY("%d개를 구매했습니다.%n"),
    PROFIT("총 수익률은 %.1f%입니다.%n");

    private final String message;

    PrintOutput(String message) {
        this.message = message;
    }

    public String message() { return message; }
}
