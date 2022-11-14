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
//            System.out.println("현재 등수 : "+thisRank + "상금 : "+price);
            updateLottosMap(myLottosMap, thisRank);
        }


    }
    public static void updateLottosMap(Map<Ranking, Integer> lottosMap, Ranking ranking){
        if (ranking != Ranking.NONE)
        {
            lottosMap.put(ranking, lottosMap.get(ranking)+1);
        }
    }
}
