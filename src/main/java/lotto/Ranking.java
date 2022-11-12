package lotto;

public enum Ranking {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5);

    private final int ranking;

    Ranking(int ranking) {
        this.ranking = ranking;
    }
}

//3개 일치 (5,000원)
//4개 일치 (50,000원)
//5개 일치 (1,500,000원)
//5개 일치, 보너스 볼 일치 (30,000,000원)
//6개 일치 (2,000,000,000원)