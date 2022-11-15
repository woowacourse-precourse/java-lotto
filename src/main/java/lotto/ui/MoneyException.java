package lotto.ui;

public class MoneyException {
    boolean b=false;
    public boolean result(){
        return b;
    }
    public MoneyException(int money) {
        if (money % 1000 != 0) {
            b=false;
        }
        if (money%1000==0){
            b=true;
        }
    }
}