package lotto;

public enum Rank {
    first("6개 일치 (2,000,000,000원)", 2000000000),
    second("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    third("5개 일치 (1,500,000원)", 1500000),
    fourth("4개 일치 (50,000원)", 50000),
    fifth("3개 일치 (5,000원)", 5000),
    etc("", 0);

    private final String comment;
    private final Integer price;

    Rank(String comment, int price) {
        this.comment = comment;
        this.price = price;
    }

    public Rank setRank(int count, boolean bonus) {
        if (count == 6) return Rank.first;
        if (count == 5 && bonus) return Rank.second;
        if (count == 5) return Rank.third;
        if (count == 4) return Rank.fourth;
        if (count == 3) return Rank.fifth;

        return Rank.etc;
    }

    public String getComment() {
        return comment;
    }

    public Integer getPrice() {
        return price;
    }

}
