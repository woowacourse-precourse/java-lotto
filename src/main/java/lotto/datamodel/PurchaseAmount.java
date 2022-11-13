package lotto.datamodel;

public class PurchaseAmount {

    private int moneyCount;
    public PurchaseAmount(String input) {
        int money = numberValid(input);
        moneyCount = moneyValid(money);
    }

    public int numberValid(String input) {
        int check;
        try{
            check = Integer.parseInt(input);
        }catch(Exception e) {
            throw new IllegalArgumentException();
        }
        return check;
    }

    public int moneyValid(int money){
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return money / 1000;
    }

    public int getMoneyCount() {
        return moneyCount;
    }

}
