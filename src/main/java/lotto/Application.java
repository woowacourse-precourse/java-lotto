package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
       int lottoCount = lottoPurchase(20000);

    }

    public static int lottoPurchase(int money){

        if(money%1000 != 0){
            new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
        }


        return money/1000;
    }
}
