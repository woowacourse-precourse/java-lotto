package lotto;
import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Money {
    public static int calcmoney (){
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        errorOnlyNumber(inputMoney);
        int money = Integer.parseInt(inputMoney);
        errorOnlyThousand(money);
        int lotto = money / 1000;
        System.out.println(lotto + "개를 구매했습니다.");
        return lotto;
    }

    public static void calcPrize(List<List<Integer>> numbers , List<Integer> lottoNumber , int bouns){
        HashMap<Integer,Integer> prize = new HashMap<Integer, Integer>();
        for (int i=-1 ; i<7 ; i++){
            prize.put(i,0);
        }
        for (int i=0 ; i<numbers.size() ; i++){
            int num = Lotto.compareNumber(numbers.get(i), lottoNumber, bouns);
            prize.put(num,prize.get(num)+1);
        }
        System.out.println("당첨 통계");
        System.out.println("---");
        prizePrint(prize);
        prizeRate(prize, numbers.size());
    }

    public static void prizePrint(HashMap<Integer, Integer> prize){
        System.out.println("3개 일치 (5,000원) - " + prize.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + prize.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prize.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prize.get(-1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prize.get(6) + "개");
    }

    public static void prizeRate(HashMap<Integer, Integer> prize, int num){
        int sum = prize.get(3)*5000 + prize.get(4)*50000 + prize.get(5)*1500000 + prize.get(-1)*30000000 + prize.get(6)*200000000;
        double rate = (sum / (num*1000)) * 100;
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

    private static void errorOnlyNumber(String input){
        for (int i=0 ; i<input.length() ; i++){
            if(input.charAt(i) > 57 || input.charAt(i) <48){
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
            }
        }
    }

    private static void errorOnlyThousand(int money){
        if (money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해주세요.");
        }
    }
}
