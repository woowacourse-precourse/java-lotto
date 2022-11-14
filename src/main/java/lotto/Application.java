package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        int payment = correctPayment(UserInputUi.ENTERCOST.getAnswer());
        payment = getCountOfLotto(payment);
        System.out.println(payment+"개를 구매했습니다.");
        LottoManager lottoManager = new LottoManager(payment);

    }

    public static int getCountOfLotto(int payment){
        return payment/1000;
    }

    public static int correctPayment(String payment){
        int cost;
        try{
            cost = Integer.parseInt(payment);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요..");
        }

        if(!(cost % 1000 == 0)){
            throw new IllegalArgumentException("[ERROR] 천 원 단위만 입력해주세요.");
        }

        return cost;
    }
}