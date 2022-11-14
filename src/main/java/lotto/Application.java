package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.LottoErrorCheck.*;
import static lotto.LottoInput.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        runLottoApp();
    }
    public static void runLottoApp(){

        int lottoCount = howMuchLottoBuyInput();

        List<Lotto> lotto = issueLotto(lottoCount);

        List<Integer> winningNumber = winningNumberInput();
        Integer bonusNumber = bonusNumberInput();
        checkBonusNumberIncludedWinningNumber(winningNumber, bonusNumber);

        List<Integer> lottoResult = resultWinningLottery(lotto, winningNumber, bonusNumber);

        double earningRate = calculateLottoEarningsRate(lottoResult, lottoCount);
        winningStatistics(lottoResult, earningRate);
    }

    public static List<Lotto> issueLotto(int lottoCount){
        System.out.println("\n"+lottoCount+"개를 구매했습니다.");
        List<Lotto> lotto = new ArrayList<>();

        for(int i = 0 ; i < lottoCount ; i++){
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1,45,6);
            lotto.add(new Lotto(lottoNumber));
            lotto.get(i).printSortedLottoNumbers();
        }

        return lotto;
    }

    public static List<Integer> resultWinningLottery(List<Lotto> lotto, List<Integer> winningNumber, Integer bonusNumber){
        List<Integer> lottoResult = Arrays.asList(0,0,0,0,0);

        int rank;
        for(int i = 0 ; i < lotto.size() ; i++) {
            rank = lotto.get(i).lottoRanking(winningNumber,bonusNumber);
            if( rank != 0 )
                lottoResult.set( rank-1 , lottoResult.get(rank-1) + 1 );
        }

        return lottoResult;
    }
    public static double calculateLottoEarningsRate(List<Integer> lottoResult, int lottoCount){
        double purchaseAmount = lottoCount * 1000;
        double earning = 0;

        String rank;
        for(int i = 0 ; i < lottoResult.size() ; i++){
            rank = "RANK"+(i+1);
            earning += lottoResult.get(i) * LottoInformation.valueOf(rank).getPrizeMoney();
        }

        double earningRate = earning / purchaseAmount * 100;
        earningRate = Math.round(earningRate*10) / 10.0;

        return earningRate;
    }
    public static void winningStatistics(List<Integer> lottoResult, double earningRate){
        System.out.println("\n당첨 통계");
        System.out.println("---");

        String rank;
        for(int i = lottoResult.size()-1 ; i >= 0 ; i--) {
            rank = "RANK" + (i + 1);
            System.out.print(LottoInformation.valueOf(rank).getResultMsg());
            System.out.println(" - " + lottoResult.get(i)+"개");
        }
        System.out.println("총 수익률은 "+earningRate+"%입니다.");
    }
}
