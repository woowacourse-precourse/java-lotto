package domain;

public class UserMoney {

    private final int THOUSAND = 1000;
    private int money;

    public int getMoney() {
        return money;
    }

    public void isDivideThousand(int money){
        if(money % THOUSAND != 0){
            throw new IllegalArgumentException();
        }
    }

}
