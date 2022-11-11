package view;

public enum Profit {
    Three(5000), Four(50000), Five(1500000),
    FiveBonus(30000000), Six(2000000000);

    private int prize = 0;

    Profit(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
