package lotto;

public enum WinningStatus {
    MATCH_THREE("3개 일치 (5,000원)", 5000d, 5),
    MATCH_FOUR("4개 일치 (50,000원)", 50000d,4),
    MATCH_FIVE("5개 일치 (1,500,000원)", 1500000d,3),
    MATCH_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000d,2),
    MATCH_SIX("6개 일치 (2,000,000,000원)", 2000000000d,1),

    NOTHING("2개 이하 일치 (0원)", 0d,0);

    private final String message;
    private final Double price;

    private final Integer grade;

    WinningStatus(String message, Double price, Integer grade){
        this.message = message;
        this.price = price;
        this.grade = grade;
    }

    public String getMessage(){
        return message;
    }

    public Double getPrice(){return price;}

    public Integer getGrade() {
        return grade;
    }
}
