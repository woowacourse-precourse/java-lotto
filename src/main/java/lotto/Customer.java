package lotto;

public class Customer {
    private int money;
    Customer(String input)throws IllegalArgumentException{
            int cash = validate(input);
            setMoney(cash);
    }

    private int validate(String input)throws IllegalArgumentException{
        int cash=0;
        if(isBitcoin(input))throw new IllegalArgumentException();
        try{
            cash=Integer.parseInt(input);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
        if(isntMod(cash))throw new IllegalArgumentException();
        if(isPoor(cash))throw new IllegalArgumentException();
        if(isElonMusk(cash))throw new IllegalArgumentException();
        return cash;
    }

    private void setMoney(int cash){
        this.money=cash;
        return;
    }
    public int getMoney(){
        return this.money;
    }

    private boolean isBitcoin(String input){
        if(input.matches(Money.REGEX))return false;
        return true;
    }
    private boolean isntMod(int cash){
        if(cash % Money.MOD==0)return false;
        return true;
    }
    private boolean isPoor(int cash){
        if(cash <= Money.MIN)return true;
        return false;
    }
    private boolean isElonMusk(int cash){
        if(cash > Money.MAX)return true;
        return false;
    }

}
