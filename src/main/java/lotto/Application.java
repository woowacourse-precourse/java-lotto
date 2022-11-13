package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
       int lottoCount = lottoPurchase(20000);

        for (int i = 0; i < lottoCount; i++) {
            issueLottoNumber();
        }
    }

    public static int lottoPurchase(int money){

        if(money%1000 != 0){
            new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
        }
        int value = money/1000;
        System.out.println(value+ "개를 구매했습니다.");

        return value;
    }

    public static List<Integer> issueLottoNumber(){
        List<Integer> issueLottoList = Randoms.pickUniqueNumbersInRange(1,25,6);

        Collections.sort(issueLottoList);

        return issueLottoList;
    }
}
