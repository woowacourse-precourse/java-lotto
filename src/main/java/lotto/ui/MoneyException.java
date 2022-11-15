package lotto.ui;

public class MoneyException {
    int flag=0;
    public int result(){
        return flag;
    }
    public MoneyException(int money) {
        if (money % 1000 != 0) {
            flag=0;
        }
        if (money%1000==0){
            flag=1;
        }
    }
}