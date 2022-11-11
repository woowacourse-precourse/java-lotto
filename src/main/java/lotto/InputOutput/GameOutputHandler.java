package lotto.InputOutput;

import lotto.controller.Lotto;
import lotto.controller.WinningPrize;

import java.util.Arrays;
import java.util.Map;

public class GameOutputHandler {
    public void requestHowMuchToBuy(){
        System.out.println("구입 금액을 입력해 주세요.");
    }
    public void checkHowMuchToBuy(int amountOfLotto){
        System.out.printf("\n%d개를 구매했습니다.\n",amountOfLotto);

    }
    public void printAllLottoPapers(Lotto[] allLottoPapers){
        for (Lotto lottoPaper : allLottoPapers) {
            printOneLottoPaper(lottoPaper);
        }
    }
    public void printOneLottoPaper(Lotto lottoPaper){
        System.out.println(Arrays.toString(lottoPaper.getNumbers().toArray()));
    }

    public void requestWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void requestBonusNumbers(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningRecord(Map<Integer, Integer> winningCounts){
        // Integer : 등수, Integer : 갯수
        System.out.print("당첨 통계\n---\n");
        for(int ranking = 5; ranking >= 1; ranking--){
            int howManyNumbersCorrect = WinningPrize.findHowManyNumbers(ranking).getHowManyNumbersIncluded();
            int winningMoney = WinningPrize.findWinningMoney(ranking).getWinningMoney();
            int amountOfThatRanking = winningCounts.get(ranking);

            System.out.printf("%d개 일치 (%d원) - %d개\n",howManyNumbersCorrect,winningMoney,amountOfThatRanking);
        }
    }
}
