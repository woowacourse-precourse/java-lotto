package lotto;

public enum Score {
    FIRST_CLASS("3개 일치 (5,0000원)"),
    SECOND_CLASS("4개 일치 (50,000원)"),
    THIRD_CLASS("5개 일치 (1,500,000원)"),
    FIRTH_CLASS("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIFTH_CLASS("6개 일치 (2,000,000,000원)");

    private String winningContent;
    
    Score (String winningContent) {
        this.winningContent = winningContent;
    }

    public String getWinningContent() {
        return this.winningContent;
    }
}
