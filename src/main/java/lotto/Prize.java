package lotto;

public enum Prize {
    FiVE("3개 일치 (5,000원)"),
    FOUR("4개 일치 (50,000원)"),
    THREE("5개 일치 (1,500,000원)"),
    TWO("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    ONE("6개 일치 (2,000,000,000원)");

    final private String Prize;

    public String getPrize() {
        return Prize;
    }

    Prize(String prize) {
        this.Prize = prize;
    }



}
