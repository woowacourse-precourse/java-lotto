package lotto;

public enum Constants {
    FIRST("6개 일치 (2,000,000,000원)", 2000000000, 1),
    SECOND("5개 일치, 보너스 볼 일치(30,000,000원),", 30000000, 2),
    THIRD("5개 일치(1,500,000원)", 1500000, 3),
    FOURTH("4개 일치(50,000원)",50000, 4),
    FIFTH("3개 일치(5,000원)", 5000, 5),
    NONE("탈락", 0, 0);
    public String gameResult;
    public int money;
    public int rank;
    private Constants(String gameResult, int money, int rank){
        this.gameResult = gameResult;
        this.money = money;
        this.rank = rank;
    }

    public static Constants calc(int match, int bonus){
        if(match == 6)
            return FIRST;
        if(match == 5 && bonus == 1)
            return SECOND;
        if(match == 5 && bonus == 0)
            return THIRD;
        if(match == 4)
            return FOURTH;
        if(match == 3)
            return FIFTH;
        return NONE;
    }

    public static Constants invert(int rank){
        if(rank == 1)
            return FIRST;
        if(rank == 2)
            return SECOND;
        if(rank == 3)
            return THIRD;
        if(rank == 4)
            return FOURTH;
        if(rank == 5)
            return FIFTH;
        return NONE;
    }
    public String getGameResult(){
        return this.gameResult;
    }

    public int getMoney(){
        return this.money;
    }

    public int getRank(){
        return this.rank;
    }
}
