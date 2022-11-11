package user;

public class Money {
    private final boolean NOT_VALID = false;
    private final boolean VALID = true;
    private final int BASE_MONEY = 1000;
    private int money;

    public Money(){
        money = 0;
    }
    public Money(int money) {
        if(isMoneyNumeric(money) && isMoneyThousandMultiple(money)) {
            this.money = money;
        }
    }

    private boolean isMoneyNumeric(int money) {
        if (isMoneyNotNull() == NOT_VALID) {
            throw new IllegalArgumentException();
        }
        if (isMoneyPositive() == NOT_VALID) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private boolean isMoneyNotNull() {
        Integer moneyObj = this.money;
        return moneyObj.equals(null);
    }

    private boolean isMoneyPositive() {
        return money >= 0;
    }

    public boolean isMoneyThousandMultiple(int money) {
        return (money % BASE_MONEY == 0) && (money / BASE_MONEY > 0);
    }

    public void setPrizeMoney(int money) {
        if(isMoneyNumeric(money) == VALID){
            this.money = money;
        }
    }

    public int getMoney() {
        return money;
    }
}
