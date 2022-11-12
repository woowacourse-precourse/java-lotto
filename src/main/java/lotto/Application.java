package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    static final Integer lottoPrice = 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("구매금액을 입력해 주세요");
        String inputMoney = sc.nextLine();
        validateInput(inputMoney);

        Integer money = Integer.parseInt(sc.nextLine());
        validateMoney(money);
        Integer nums = money/lottoPrice;

        List<Lotto> lottos = new ArrayList<>();
        for(Integer num = 0; num<nums; num++) {
            List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto =new Lotto(lottoNums);
            lottos.add(lotto);
        }




    }

    static void validateInput(String inputMoney){
        try{
            Integer money = Integer.parseInt(inputMoney);
        }catch(Throwable e){
            System.out.println("[ERROR] 금액을 정확히 입력해 주시기 바랍니다.");
            throw new IllegalArgumentException("[ERROR] 금액을 정확히 입력해 주시기 바랍니다.");
        }
    }

    static void validateMoney(Integer money){
        if(money%1000 != 0){
            System.out.println("[ERROR] 1000원 단위로 금액을 입력해 주시기 바랍니다.");
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 금액을 입력해 주시기 바랍니다.");
        }
    }
}
