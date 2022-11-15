package domain;

public enum LottoRank {
    WIN_LOTTO_3("3개 번호 일치" , 3),
    WIN_LOTTO_4("4개 번호 일치" , 4),
    WIN_LOTTO_5("5개 번호 일치" , 5),
    WIN_LOTTO_5_BONUS("5개 번호 일치 + 보너스 일치" , 5 ),
    WIN_LOTTO_6("6개 번호 일치" , 6);

    private final String description;
    private final int count;

    LottoRank(String description , int count) {
        this.description = description;
        this.count = count;
    }

    public String getDescription(){
        return description;
    }

    public int getCount(){
        return count;
    }
}
