package lotto;

public enum Constants {
    FIRST("6개 일치", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치,", 30000000),
    THIRD("5개 일치", 1500000),
    FOURTH("4개 일치",50000),
    FIFTH("3개 일치", 5000);

    public String gameResult;
    public int money;
    private Constants(String gameResult, int money){
        this.gameResult = gameResult;
        this.money = money;
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
        return this.FIFTH;
    }

    public String getGameResult(){
        return this.gameResult;
    }

    public int getMoney(){
        return this.money;
    }


}
