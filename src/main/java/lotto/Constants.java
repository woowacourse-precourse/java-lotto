package lotto;

public enum Constants {
    FIRST("6개 일치", 2000000000, 1),
    SECOND("5개 일치, 보너스 볼 일치,", 30000000, 2),
    THIRD("5개 일치", 1500000, 3),
    FOURTH("4개 일치",50000, 4),
    FIFTH("3개 일치", 5000, 5),
    NONE("탈락", 0, 0);
    public String gameResult;
    public int money;
    public int rank;
    private Constants(String gameResult, int money, int rank){
        this.gameResult = gameResult;
        this.money = money;
        this.rank = rank;
    }

    public Constants calc(int match, int bonus){
        if(match == 6)
            return this.FIRST;
        if(match == 5 && bonus == 1)
            return this.SECOND;
        if(match == 5 && bonus == 0)
            return this.THIRD;
        if(match == 4)
            return this.FOURTH;
        if(match == 3)
            return this.FIFTH;
        return this.NONE;
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
