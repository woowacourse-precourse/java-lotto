package lotto.constant;

public enum Rank {
    FIFTH("3개 일치", 5000),
    FOURTH("4개 일치", 50000),
    THIRD("5개 일치", 1500000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    FIRST("6개 일치", 2000000000);

    private final String condition;
    private final int winningAmount;
    private static Rank[] list = Rank.values();

    Rank(String condition, int winningAmount){
        this.condition = condition;
        this.winningAmount = winningAmount;
    }

    public String condition(){
        return condition;
    }

    public int winningAmount(){
        return winningAmount;
    }

    public static Rank get(int index){
        return list[index];
    }
}
