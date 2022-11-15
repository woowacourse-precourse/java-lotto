package data;

public enum OutputData {
    WINNING_RESULT("당첨 통계"),
    LINE("---"),
    NUMBER_COUNT("개 일치"),
    SECOND_PRIZE(", 보너스 볼 일치"),
    OPEN_BRACKET("("),
    CLOSE_BRACKET(") - "),
    COUNT("개"),
    OPEN_PROFIT_RATE("총 수익률은 "),
    CLOSE_PROFIT_RATE("%입니다.");

    private final String outputData;

    OutputData(String outputData) {
        this.outputData = outputData;
    }

    public String getOutputData() {
        return outputData;
    }
}
