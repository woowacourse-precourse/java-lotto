package util;

public enum ResultView {
    Three("3개 일치 (5,000원) - "),
    Four("4개 일치 (50,000원) - "),
    Five("5개 일치 (1,500,000원) - "),
    Bonus("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    Six( "6개 일치 (2,000,000,000원) - ")
    ;

    private final String label;

    ResultView(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
