package lotto;

public enum PrizeEnum {

    CORRECT_3(5000, "3개 일치 (5,000원)"),
    CORRECT_4(50000, "4개 일치 (50,000원)"),
    CORRECT_5(1500000, "5개 일치 (1,500,000원)"),
    CORRECT_5_bonus(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    CORRECT_6(2000000000, "6개 일치 (2,000,000,000원)");

    private final String prizeName;
    private final Integer prize;

    PrizeEnum(Integer prize, String prizeName) {
        this.prize = prize;
        this.prizeName = prizeName;
    }

    public String getPrizeName(){
        return prizeName;
    }

    public Integer getPrize(){
        return prize;
    }

}
