package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.Constant.ASK_PRICE;
import static lotto.Constant.SHOW_BUY_COUNT;
import static lotto.Game.*;

public class Buy {
    public static int HowMuch() {
        System.out.println(ASK_PRICE);
        String price = Console.readLine();
        nLottoPrice = validatePrice(price);
        validate1000(nLottoPrice);
        nLotto = nLottoPrice / 1000;
        //Lotto exception 필요
        return nLotto;
    }

    public static int validatePrice(String price){
        try{
            nLottoPrice = Integer.parseInt(price);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 금액(숫자)을 입력하세요");}
        return nLottoPrice;
    }

    public static void validate1000(int nLottoPrice){
        if (nLottoPrice % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000의 배수여야 합니다.");
        }
    }
}
