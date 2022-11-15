package lotto;

import java.util.*;
import java.text.NumberFormat;
import java.lang.IllegalArgumentException;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static int money;
    static int lottoNum;
    static List<Lotto> lottoList;
    static int castInt(String str){
        int num = 0;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException ex){
            throw new IllegalArgumentException(); //Error message 추후 수정
        }
        return num;
    }

    static int payMoney(){
        int inputMoney = castInt(Console.readLine());
        return inputMoney;
    }
    static List<Integer> createLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    static List<Lotto> createLottoList(int lottoNum){
        List<Lotto> lottoList = new ArrayList<>(lottoNum);
        for (int lottoIndex = 0; lottoIndex < lottoNum; lottoIndex++) {
            lottoList.add(new Lotto(createLotto()));
        }
        return lottoList;
    }

    public static void main(String[] args) {
        System.out.println("구매금액을 입력해주세요");
        money = payMoney();
        lottoNum = money / 1000;
        System.out.println(lottoNum + "개를 구매했습니다.");
    }
}
