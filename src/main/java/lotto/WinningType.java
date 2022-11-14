package lotto;

public enum WinningType {
    NOTHING(0, 0, "", 0),
    MATCH3(3, 0, "3개 일치 (5,000원)", 5000),
    MATCH4(4, 0, "4개 일치 (50,000원)", 50000),
    MATCH5(5, 0, "5개 일치 (1,500,000원)", 1500000),
    MATCH5WITHBONUS(7, 0, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    MATCH6(6, 0, "6개 일치 (2,000,000,000원)", 2000000000);


    public final int key;
    public int value;
    public final String message;
    public final int price;

    WinningType(int key, int value, String message, int price){
        this.key = key;
        this.value = 0;
        this.message = message;
        this.price = price;
    }

    public void increaseValue(){
        this.value++;
    }

    public int getKey(){
        return this.key;
    }

    public int getValue(){
        return this.value;
    }

    public String printMessage(){
        if(this == WinningType.NOTHING) return "";
        return (this.message + " - " + this.value + "개");
    }

    public static WinningType getType(int key){
        for(WinningType wt:WinningType.values()){
            if(wt.getKey() == key) return wt;
        }
        return NOTHING;
    }

}
