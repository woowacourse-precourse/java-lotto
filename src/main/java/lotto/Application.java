package lotto;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void validate(int value){
        if (value % 1000 !=0) {
            System.out.println("[ERROR] 구입 금액은 1000원 단위입니다.");
            throw new IllegalArgumentException();
        }
    }
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int buyingValue = Integer.parseInt(Console.readLine());
        validate(buyingValue);

        int countOfLotto = buyingValue/1000;
        System.out.println(countOfLotto+"개를 구매했습니다.");
        List<Lotto> myLottos = new ArrayList<Lotto>();
        for(int i=0;i<countOfLotto;i++)
        {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            myLottos.add(new Lotto(numbers));
            myLottos.get(i).printNumbers();
        }

        List<Integer> winningNum = new ArrayList<Integer>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputString = Console.readLine();
        String winningStr[] = inputString.split(",");
        for(String num:winningStr)
        {
            winningNum.add(Integer.parseInt(num));
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bounusNum = Integer.valueOf(Console.readLine());
        Map<Ranking,Integer> myLottosMap = new HashMap<Ranking, Integer>(){{
            put(Ranking.FIRST, 0);
            put(Ranking.SECOND, 0);
            put(Ranking.THIRD, 0);
            put(Ranking.FOURTH, 0);
            put(Ranking.FIFTH, 0);
        }};
        for (int i=0;i<countOfLotto;i++)
        {
            int countOfMatch = myLottos.get(i).getNumberOfMatch(winningNum,bounusNum);
            boolean isMatchBounus = myLottos.get(i).isContainBounus(bounusNum);
            Ranking thisRank = Ranking.getRank(countOfMatch, isMatchBounus);
//            System.out.priintln("현재 등수 : "+thisRank + "상금 : "+price);
            updateLottosMap(myLottosMap, thisRank);
        }
        displayResult(myLottosMap, buyingValue);


    }

//    3개 일치 (5,000원) - 1개
//4개 일치 (50,000원) - 0개
//5개 일치 (1,500,000원) - 0개
//5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
//6개 일치 (2,000,000,000원) - 0개
    public static void displayResult(Map<Ranking, Integer> map, int buyingValue){
        int resultTotal =0;

        System.out.println("3개 일치 ("+String.valueOf(Ranking.FIFTH.getMoney()).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")+") - "+map.get(Ranking.FIFTH)+"개");
        resultTotal += map.get(Ranking.FIFTH) * Ranking.FIFTH.getMoney();

        System.out.println("4개 일치 ("+String.valueOf(Ranking.FOURTH.getMoney()).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")+") - "+map.get(Ranking.FOURTH)+"개");
        resultTotal += map.get(Ranking.FOURTH) * Ranking.FOURTH.getMoney();

        System.out.println("5개 일치 ("+String.valueOf(Ranking.THIRD.getMoney()).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")+") - "+map.get(Ranking.THIRD)+"개");
        resultTotal += map.get(Ranking.THIRD) * Ranking.THIRD.getMoney();

        System.out.println("5개 일치 ("+String.valueOf(Ranking.SECOND.getMoney()).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")+") - "+map.get(Ranking.SECOND)+"개");
        resultTotal += map.get(Ranking.SECOND) * Ranking.SECOND.getMoney();

        System.out.println("6개 일치 ("+String.valueOf(Ranking.FIRST.getMoney()).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")+") - "+map.get(Ranking.FIRST)+"개");
        resultTotal += map.get(Ranking.FIRST) * Ranking.FIRST.getMoney();

        System.out.println("총 수익률은 "+(float)resultTotal/buyingValue+"%입니다");
    }

    public static void updateLottosMap(Map<Ranking, Integer> lottosMap, Ranking ranking){
        if (ranking != Ranking.NONE)
        {
            lottosMap.put(ranking, lottosMap.get(ranking)+1);
        }
    }
}
