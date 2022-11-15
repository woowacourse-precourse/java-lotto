package lotto.model;

import lotto.Enum.Error;
import lotto.Enum.Number;

public class Purchase {
    private static int purchaseMoney = 0;

    public Purchase(String PurchaseMoney){
        int money = isInteger(PurchaseMoney);
        isCorrectUnit(money);
        isBelowMin(money);

        this.purchaseMoney = money;
    }

    public int getPurchaseMoney(){
        return purchaseMoney;
    }
    public int getLottoTickets(){
        return purchaseMoney/ Number.UNIT.getValue();
    }

    private Integer isInteger(String PurchaseMoney){
        try{
            return Integer.parseInt(PurchaseMoney);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException(Error.NUMBER.getMessage());
        }
    }

    private static void isCorrectUnit(int money){
        if(money % 1000 != 0) throw new IllegalArgumentException(Error.UNIT.getMessage());
    }

    private static void isBelowMin(int money){
        if(money < 1000) throw new IllegalArgumentException(Error.BELOW.getMessage());
    }
}
