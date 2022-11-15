package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.UserLotto;
import lotto.domain.WinLotto;
import lotto.domain.WinStatistics;
import lotto.domain.WinningRank;
import lotto.view.UserView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private static final int INIT = 0;
    private static final int PERCENTAGE = 100;
    private UserLotto user = new UserLotto();
    private UserView userView = new UserView();
    private WinLotto winLotto = new WinLotto();
    private WinStatistics winStatistics = new WinStatistics();
    private static List<Integer> countAccord;
    private static int bonusAccord;

    public LottoGame() {}

    public void startLotto(){
        userView.printPurchaseAmountNotice();
        String purchaseAmount = Console.readLine();

        int lottoCount = user.setPurchaseOfLotto(purchaseAmount);
        userView.printNumberOfPurchases(lottoCount);
        user.setPurchaseLottoNumbers(lottoCount);
        getPurchaseLottoNumbers(lottoCount);

        userView.printWinningNumbersNotice();
        String winningNumbers = Console.readLine();
        winLotto.setWinningNumbers(winningNumbers);

        userView.printBonusNumbersNotice();
        String bonusNumber = Console.readLine();
        winLotto.setBonusNumber(bonusNumber);

        userView.printWinStatistics();
        winStatistics.startWinStatistics();
        getAccord();

        printResult();

        String rateOfReturn = getRateOfReturn(purchaseAmount);
        userView.printRateOfReturn(rateOfReturn);
    }

    public void getPurchaseLottoNumbers(int lottoCount){
        for(int i=INIT;i<lottoCount;i++){
            List<Integer> userNumbers = new ArrayList<>(user.getPurchaseLottoGroup(i));
            userView.printPurchaseLottoNumbers(userNumbers);
        }
    }

    public void getAccord(){
        countAccord = winStatistics.getCountAccord();
        bonusAccord = winStatistics.getBonusAccord();
    }

    public String getRateOfReturn(String purchaseAmount){
        return String.format("%,.1f",(double)winStatistics.calculationTotalAmount()/Double.parseDouble(purchaseAmount) * PERCENTAGE);
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



}
