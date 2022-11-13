package lotto.service;

public enum printChart {
    ASK_PURCHASE("구입금액을 입력해 주세요."),
    PRINT_EMPTY(" "),
    PRINT_NUMBER("개를 구매했습니다."),
    ASK_WIN("당첨 번호를 입력해 주세요."),
    ASK_BONUS("보너스 번호를 입력해 주세요."),
    PRINT_STATISTICS("당첨 통계"),
    PRINT_LINE("---"),
    PRINT_THREE("3개 일치 (5,000원) - "),
    PRINT_FOUR("4개 일치 (50,000원) - "),
    PRINT_FIVE("5개 일치 (1,500,000원) - "),
    PRINT_FIVE_FLUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    PRINT_SIX("6개 일치 (2,000,000,000원) - "),
    REPORT_RATE("총 수익률은 "),
    PRINT_GE("개"),
    PRINT_PERCENT("%입니다.");


    private final String value;

    printChart(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
