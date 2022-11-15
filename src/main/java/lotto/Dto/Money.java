package lotto.Dto;

public class Money {
    private int money;

    public Money(String money){
        if(validValue(money)){
            this.money = Integer.valueOf(money) ;
        }


    }

    public int getMoney() {
        return money;
    }

    private boolean validValue(String money) throws IllegalArgumentException{
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("[ERROR] 숫자만을 입력하시오");
        String pattern = ".*[A-Za-zㄱ-ㅎ].*$";

        try{
            if(money.matches(pattern)){
                System.out.print(illegalArgumentException.getMessage());
                throw illegalArgumentException;
            }
        }catch (IllegalArgumentException e){
            return false;
        }

        return true;

    }
}
