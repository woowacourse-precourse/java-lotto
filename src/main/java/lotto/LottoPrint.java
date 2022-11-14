package lotto;

public enum LottoPrint {
    First("6개 일치 (2,000,000,000원)"),
    Second("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    Third("5개 일치 (1,500,000원)"),
    Fourth("4개 일치 (50,000원)"),
    Fifth("3개 일치 (5,000원)");

    private String description;

    LottoPrint(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}