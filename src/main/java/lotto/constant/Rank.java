package lotto.constant;

public enum Rank {
    NOTHING("꽝", 0, "0원"),
    FIFTH("3개 일치", 5000, "5,000원"),
    FOURTH("4개 일치", 50000, "50,000원"),
    THIRD("5개 일치", 1500000, "1,500,000원"),
    SECOND("5개 일치, 보너스 볼 일치", 30000000, "30,000,000원"),
    FIRST("6개 일치", 2000000000, "2,000,000,000원");

    private final String condition;
    private final int winningAmount;
    private final String printingFormatOfAmount;
    private static final Rank[] list = Rank.values();

    private static final int size = list.length;

    Rank(String condition, int winningAmount, String printingFormatOfAmount){
        this.condition = condition;
        this.winningAmount = winningAmount;
        this.printingFormatOfAmount = printingFormatOfAmount;
    }

    public String condition(){
        return condition;
    }

    public int winningAmount(){
        return winningAmount;
    }
    public String printingFormatOfAmount(){
        return printingFormatOfAmount;
    }

    public static Rank get(int index){
        return list[index];
    }

    public static int size(){
        return size;
    }

}
