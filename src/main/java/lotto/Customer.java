package lotto;

public class Customer {
    private int money;

    Customer(String input)throws IllegalArgumentException{
            int cash = validate(input);
            setMoney(cash);
    }

    private int validate(String input)throws IllegalArgumentException{
        int cash=0;
        if(isBitcoin(input))throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        try{
            cash=Integer.parseInt(input);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 너무 큰 숫자를 입력하였습니다.");
        }
        if(isntMod(cash))throw new IllegalArgumentException("[ERROR] 1000단위로 입려해 주세요.");
        if(isPoor(cash))throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력해 주세요");
        if(isElonMusk(cash))throw new IllegalArgumentException("[ERROR] 1,000,000,000원 이하의 금액을 입력해주세요.");
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
        if(cash < Money.MIN)return true;
        return false;
    }
    private boolean isElonMusk(int cash){
        if(cash > Money.MAX)return true;
        return false;
    }

}
