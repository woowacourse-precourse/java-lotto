package lotto;

public enum Prize {
    THREE(5000),
    FORU(50000),
    FIVE(1500000),
    SIX(2000000000),
    SEVEN(30000000);

    //3개 일치 (5,000원) - 1개
    //4개 일치 (50,000원) - 0개
    //5개 일치 (1,500,000원) - 0개
    //5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    //6개 일치 (2,000,000,000원) - 0개
    //총 수익률은 62.5%입니다.


    private int prize;

    Prize(int prize) {
        this.prize = prize;
    }

    public int getPrize(){
        return prize;
    }

}
