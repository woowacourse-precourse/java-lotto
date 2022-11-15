package lotto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PrintDriver {
    public void printInputBuyingAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void printCountOfLotteryMessage(int countOfLottery) {
        System.out.println("\n"+countOfLottery+"개를 구매했습니다.");
    }
    public void printLotteryBundle(int[][] lotteryBundle) {
        for (int row = 0 ; row < lotteryBundle.length; row++){
            System.out.println(Arrays.stream(lotteryBundle[row]).boxed().collect(Collectors.toList()));
        }
    }
    void printInputNumbersMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }
    void printInputBonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }
    public void printStatusOfWinning(int[] countCaseCount, double totalProfitRate) {
        printCountCasesTitleMessage();
        for (WinningPrize count : WinningPrize.values()){
            int countValue = count.countOfContain;
            String bonusMessage = "";
            String winningPrize = count.winningPrize;
            int caseCount = countCaseCount[count.countOfContain];
            if (count.countOfContain == 7){
                countValue -= 2;
                bonusMessage += ", 보너스 볼 일치";
            }
            printCountCaseMessage(countValue,bonusMessage,winningPrize,caseCount);
        }
        printTotalProfitRate(totalProfitRate);
    }
    private void printCountCasesTitleMessage() {
        System.out.println("\n당첨 통계\n---");
    }
    private void printCountCaseMessage(int countValue, String bonusMessage, String winningPrize, int caseCount) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println(countValue + "개 일치"+ bonusMessage + " (" + formatter.format(Integer.parseInt(winningPrize)) +"원) - " + caseCount + "개");
    }
    private void printTotalProfitRate(double totalProfitRate) {
        System.out.println("총 수익률은 " + totalProfitRate + "%입니다.");
    }
}
