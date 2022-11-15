package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.UserLotto;
import lotto.domain.WinLotto;
import lotto.domain.WinStatistics;
import lotto.domain.WinningRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private UserLotto user = new UserLotto();
    private WinLotto winLotto = new WinLotto();
    private WinStatistics winStatistics = new WinStatistics();
    private static List<Integer> countAccord;
    private static int bonusAccord;
    public LottoGame() {
    }

    public void startLotto(){
        printPurchaseAmount();

        int input = user.setPurchaseAmount();
        user.validateUnit(input);
        int lottoCount = setPurchaseAmount(input);

        printNewLine();
        String sb1 = lottoCount+"개를 구매했습니다.";
        System.out.println(sb1);
        setPurchaseAmountLotto(lottoCount);

        user.getPurchaseLottoNumbers();
        printNewLine();

        printWinningNumbers();
        winLotto.setWinningNumbers();

        printNewLine();
        printBounsNumbers();
        winLotto.setBounsNumber();

        printNewLine();
        printWinStatistics();
        System.out.println("---");
        winStatistics.startWinStatistics();
        countAccord = winStatistics.getCountAccord();
        bonusAccord = winStatistics.getBonusAccord();

        printResult();

        double rateOfReturn2 = (double)winStatistics.calculationTotalAmount()/(double)input * 100;
        String rateOfReturn = String.format("%,.1f",rateOfReturn2);
        String sb5 = "총 수익률은 " + rateOfReturn + "%입니다.";
        System.out.println(sb5);
    }

    public void setPurchaseAmountLotto(int input) {
        while (input > 0) {
            user.setRandomNumber();
            input--;
        }
    }

    public int setPurchaseAmount(int input) {
        return input / 1000;
    }

    public void printResult(){
        for(int i=3;i<=6;i++){
            String sb3 = "";
            if(i==3){
                sb3 = i + "개 일치 (" + WinningRank.THREE.getAmount() + ") - " + countAccord.get(i) + "개";
                System.out.println(sb3);
            }else if(i==4){
                sb3 = i + "개 일치 (" + WinningRank.FOUR.getAmount() + ") - " + countAccord.get(i) + "개";
                System.out.println(sb3);
            }else if(i==5){
                sb3 = i + "개 일치 (" + WinningRank.FIVE.getAmount() + ") - " + countAccord.get(i) + "개";
                System.out.println(sb3);

                String sb4 = i + "개 일치, 보너스 볼 일치 (" + WinningRank.BONUS.getAmount() + ") - " + bonusAccord + "개";
                System.out.println(sb4);
            }else if(i==6){
                sb3 = i + "개 일치 (" + WinningRank.SIX.getAmount() + ") - " + countAccord.get(i) + "개";
                System.out.println(sb3);
            }
        }
    }

    public void printPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBounsNumbers() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinStatistics() {
        System.out.println("당첨 통계");
    }

    public void printNewLine() {
        System.out.println();
    }

}
