package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        SystemMessage.INPUT_MONEY.print();
        int money = Integer.parseInt(readLine());
        int buyingCount = money / 1000;

        System.out.print(buyingCount);
        SystemMessage.OUTPUT_LOTTO_COUNT.print();

        List<Lotto> myLottos = new ArrayList<Lotto>();
        for(int i=0; i<buyingCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            myLottos.add(new Lotto(numbers));
            System.out.println(myLottos.get(i));
        }

        List<Integer> winningNumber = new ArrayList<Integer>();
        SystemMessage.INPUT_LOTTO_NUMBER.print();
        String inputString = Console.readLine();
        String winningString[] = inputString.split(",");
        for(String num:winningString) {
            winningNumber.add(Integer.parseInt(num));
        }

        SystemMessage.INPUT_BONUS_NUMBER.print();
        int bonusNumber = Integer.parseInt(Console.readLine());

        Map<Result,Integer> myLottosMap = new HashMap<Result, Integer>(){{
            put(Result.FIRST, 0);
            put(Result.SECOND, 0);
            put(Result.THIRD, 0);
            put(Result.FOURTH, 0);
            put(Result.FIFTH, 0);
        }};
        for (int i=0;i<buyingCount;i++) {
            int countOfMatch = myLottos.get(i).getNumbersOfMatch(winningNumber);
            boolean isMatchBonus = myLottos.get(i).isContainBonus(bonusNumber);
            Result thisResult = Result.getResult(countOfMatch, isMatchBonus);
            updateLottosMap(myLottosMap, thisResult);
        }
        printResult(myLottosMap, buyingCount);

    }

    public static void printResult(Map<Result, Integer> map, int buyingValue){
        int resultTotal =0;

        System.out.println("3개 일치 ("+String.valueOf(Result.FIFTH.getPrice()).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")+") - "+map.get(Result.FIFTH)+"개");
        resultTotal += map.get(Result.FIFTH) * Result.FIFTH.getPrice();

        System.out.println("4개 일치 ("+String.valueOf(Result.FOURTH.getPrice()).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")+") - "+map.get(Result.FOURTH)+"개");
        resultTotal += map.get(Result.FOURTH) * Result.FOURTH.getPrice();

        System.out.println("5개 일치 ("+String.valueOf(Result.THIRD.getPrice()).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")+") - "+map.get(Result.THIRD)+"개");
        resultTotal += map.get(Result.THIRD) * Result.THIRD.getPrice();

        System.out.println("5개 일치 ("+String.valueOf(Result.SECOND.getPrice()).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")+") - "+map.get(Result.SECOND)+"개");
        resultTotal += map.get(Result.SECOND) * Result.SECOND.getPrice();

        System.out.println("6개 일치 ("+String.valueOf(Result.FIRST.getPrice()).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")+") - "+map.get(Result.FIRST)+"개");
        resultTotal += map.get(Result.FIRST) * Result.FIRST.getPrice();

        System.out.println("총 수익률은 "+(float)resultTotal/buyingValue+"%입니다");
    }

    public static void updateLottosMap(Map<Result, Integer> lottosMap, Result ranking){
        if (ranking != Result.DEFAULT)
        {
            lottosMap.put(ranking, lottosMap.get(ranking)+1);
        }
    }
}
