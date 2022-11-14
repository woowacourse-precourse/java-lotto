package lotto.function;

import java.util.Collections;
import java.util.List;


public class Validation {

    public static void validatePurchase(int price){
        if(price%1000!=0) throw new IllegalArgumentException("[ERROR] 입력한 값이 1000원 단위가 아닙니다.");
    }
}
