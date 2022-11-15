package lotto.Code;

public enum LottoCode {
    CORRECT_3(5000, "3개 일치 (5,000원) - "),
    CORRECT_4(500000, "4개 일치 (50,000원) - "),
    CORRECT_5(1500000, "5개 일치 (1,500,000원) - "),
    CORRECT_5_WITH_BONUS(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    CORRECT_6(2000000000, "6개 일치 (2,000,000,000원) - ");

    private int prize;
    private String message;

    private LottoCode(int prize, String message){
        this.prize = prize;
        this.message = message;
    }

    public int getPrize(){return this.prize;}
    public String getMessage(){return this.message;}
}