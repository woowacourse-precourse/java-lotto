package lotto.view;

public enum PrintMassage {
    PURCHASE_LIST("개를 구매했습니다."),
    END_SENTENCE("당첨 통계\n---"),
    COUNT("개"),
    CORRECT_THREE("3개 일치 (5,000원) - "),
    CORRECT_FOUR("4개 일치 (50,000원) - "),
    CORRECT_FIVE("5개 일치 (1,500,000원) - "),
    CORRECT_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    CORRECT_SIX("6개 일치 (2,000,000,000원) - "),
    ALL_RATIO("총 수익률은 "),
    ALL_RATIO_SEC("%입니다.");

    private final String message;

    PrintMassage(String message) {
        this.message = message;
    }

    public String message(){
        return message;
    }
}
