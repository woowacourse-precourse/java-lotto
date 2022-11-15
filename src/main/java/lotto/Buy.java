package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.Constant.ASK_PRICE;
import static lotto.Game.*;
import static lotto.ErrorMessage.*;

public class Buy {
    public static int HowMuch() {
        System.out.println(ASK_PRICE);
        String price = Console.readLine();
        nLottoPrice = validatePrice(price);
        validate1000(nLottoPrice);
        nLotto = nLottoPrice / 1000;
        return nLotto;
    }

    public static int validatePrice2(String price){
        for (char c : price.toCharArray()) {
            if (!('0' <= c && c <= '9')) {
                throw new IllegalArgumentException(PURCHASE_MONEY_IS_INTEGER.getMsg());
            }
        }
        nLottoPrice = Integer.parseInt(price);
        return nLottoPrice;
    }
    public static int validatePrice(String price){
        try{
            nLottoPrice = Integer.parseInt(price);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(PURCHASE_MONEY_IS_INTEGER.getMsg());}
        return nLottoPrice;
    }

    public static void validate1000(int nLottoPrice){
        if (nLottoPrice % 1000 != 0){
            throw new IllegalArgumentException(PURCHASE_MONEY_DIVIDABLE.getMsg());
        }
    }
}
