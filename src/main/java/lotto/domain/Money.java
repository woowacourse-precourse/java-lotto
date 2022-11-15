package lotto.domain;

public class Money {
    private long money;

    public Money(String money){
        this.money = Long.parseLong(money);
    }

    private void checkValidation(Integer money){
        if(money % 1000 !=0){
            System.out.println(Message.MONEY_CANT_DIVIED_BY_1000);
        }
        if(money < 1000){
            System.out.println(Message.MONEY_IS_LOWER_THAN_1000);
        }
    }

}
