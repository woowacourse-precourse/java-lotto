package lotto;

enum Prize {
    FIRST(2000000000, 1),
    SECOND(30000000, 2),
    THIRD(1500000, 3),
    FORTH(50000, 4),
    FIFTH(5000, 5);

    private final int prize;
    private final int name;
    Prize(int money, int name){
        this.prize = money;
        this.name = name;
    }

    public int getPrize(){
        return prize;
    }

    public int getName(){
        return name;
    }
}
