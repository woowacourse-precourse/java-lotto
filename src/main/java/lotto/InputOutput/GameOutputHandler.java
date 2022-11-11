package lotto.InputOutput;

import lotto.controller.Lotto;
import lotto.controller.WinningPrize;

import java.util.Arrays;
import java.util.Map;

public class GameOutputHandler {
    static int totalEarnMoney;

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

    public void printAllRecord(Map<Integer, Integer> winningCounts, int buyingMoney){
        printWinningRecord(winningCounts);
        printProfitRate(buyingMoney);
    }

    public void printWinningRecord(Map<Integer, Integer> winningCounts){
        totalEarnMoney = 0;
        System.out.print("당첨 통계\n---\n");
        for(int ranking = 5; ranking >= 1; ranking--){
            int howManyNumbersCorrect = WinningPrize.findHowManyNumbers(ranking).getHowManyNumbersIncluded();
            int winningMoney = WinningPrize.findWinningMoney(ranking).getWinningMoney();
            int amountOfThatRanking;

            try{
                amountOfThatRanking = winningCounts.get(ranking);
            }catch(NullPointerException ex){
                amountOfThatRanking = 0;
            }

            totalEarnMoney += (winningMoney * amountOfThatRanking);
            boolean isSecondRank = (ranking == 2);
            printWinningRecordOneByOne(howManyNumbersCorrect,winningMoney,amountOfThatRanking,isSecondRank);
        }
    }

    private void printProfitRate(int buyingMoney){
        double rate = ((double)totalEarnMoney / (double)buyingMoney) * 100;
        double roundOff = Math.round(rate * 100.0) / 100.0;
        System.out.print("총 수익률은 " + roundOff + "% 입니다.");
    }
    private void printWinningRecordOneByOne(int numbersCorrect, int winningMoney, int amountOfThatRanking, boolean isSecondRank){
        StringBuilder printMake = new StringBuilder();
        printMake.append(String.format("%d개 일치",numbersCorrect));

        if(isSecondRank){
            printMake.append(", 보너스 볼 일치");
        }

        printMake.append(String.format(" (%s원)",insertCommaInMoney(winningMoney)));
        printMake.append(String.format(" - %d개",amountOfThatRanking));
        System.out.println(printMake);
    }
    private String insertCommaInMoney(int winningMoney){
        StringBuilder originalToReverse = new StringBuilder(Integer.toString(winningMoney)).reverse();
        StringBuilder forMake = new StringBuilder();

        for(int stringIndex = 0; stringIndex < originalToReverse.length(); stringIndex++){
            if((stringIndex != 0) && (stringIndex % 3 == 0)){
                forMake.append(",");
            }
            forMake.append(originalToReverse.charAt(stringIndex));
        }

        return forMake.reverse().toString();
    }
}
