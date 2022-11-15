package lotto.domain;

import lotto.view.InputMessage;

import java.util.HashMap;
import java.util.List;

public class Output {
    public HashMap<Integer, Integer> countOfPrize = new HashMap<>();
    public void outputLotteries(int pay, List<List<Integer>> lotteries){
        System.out.println(String.valueOf(pay) + InputMessage.amoutOfLotto.getValue());
        for (List<Integer> lottery : lotteries) {
            System.out.println(lottery);
        }
    }
    public HashMap<Integer, Integer> createMakeOfPrize (List<Integer> winningTable) {
        for (int result : winningTable) {
            countOfPrize.put(result, countOfPrize.getOrDefault(result, 0) + 1);
        }
        return countOfPrize;
    }
    public void writeDown(double earningRate){
        Calculator calculator = new Calculator();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+countOfPrize.getOrDefault(3,0)+"개");
        System.out.println("4개 일치 (50,000원) - "+countOfPrize.getOrDefault(4,0)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+countOfPrize.getOrDefault(5,0)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+countOfPrize.getOrDefault(7,0)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+countOfPrize.getOrDefault(6,0)+"개");
        System.out.println("총 수익률은 "+earningRate+"%입니다.");

    }
}
