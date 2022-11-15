package lotto.enums;

public enum StatisticMessage {
    CORRECT_3(0, "3개 일치 (5,0000원) - "),
    CORRECT_4(1, "4개 일치 (50,000원) - "),
    CORRECT_5(2, "5개 일치 (1,500,000원) - "),
    CORRECT_5_BONUS(3, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    CORRECT_6(4, "6개 일치 (2,000,000,000원) - ");

    private final int idx;
    private final String message;

    public int getIdx() {
        return idx;
    }

    public String getMessage() {
        return message;
    }

    StatisticMessage(int idx, String message) {
        this.idx = idx;
        this.message = message;
    }

    public static StatisticMessage printIdx(int idx){
        for (StatisticMessage statisticMessage: StatisticMessage.values()){
            if(statisticMessage.idx == idx){
                return statisticMessage;
            }
        }
        throw new IllegalArgumentException();
    }
}
