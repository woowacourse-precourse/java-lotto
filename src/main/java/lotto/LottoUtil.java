package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoUtil {

    public static int numberOfLottoAvailableCount(int userMoney) {
        return userMoney/1000;
    }

    public static List<Lotto> getLottos(int userLottoCnt) {

        PrintUtil.getLottos(userLottoCnt);

        List<Lotto> userLottos = new ArrayList<>();

        for(int i = 0 ; i < userLottoCnt ; i++){
            List<Integer> tmpList = Randoms.pickUniqueNumbersInRange(1,45,6);
            List<Integer> lottoNumbers = new ArrayList<>(tmpList);
            Collections.sort(lottoNumbers);
            userLottos.add(new Lotto(lottoNumbers));
        }

        PrintUtil.userLottosPrint(userLottos);

        return userLottos;
    }

    public static List<Integer> checkWin(List<Lotto> userLottos, List<Integer> winNumber) {
        List<Integer> winStatistics = new ArrayList<>();

        for(Lotto lotto : userLottos){
            int cnt = checkWin(lotto, winNumber);
            winStatistics.add(cnt);
        }

        return winStatistics;
    }

    public static int checkWin(Lotto lotto, List<Integer> winNumber) {
        int cnt = 0;

        for(int number : lotto.getNumbers()){
            if(winNumber.contains(number)){
                cnt++;
            }
        }
        return cnt;
    }

    public static List<Boolean> checkBonus(List<Lotto> userLottos, int bonusNumber) {
        List<Boolean> bonusStatistics = new ArrayList<>();

        for(Lotto lotto : userLottos){
            boolean cnt = checkBonus(lotto, bonusNumber);
            bonusStatistics.add(cnt);
        }
        return bonusStatistics;
    }

    public static boolean checkBonus(Lotto lotto, int bonusNumber) {

        if(lotto.getNumbers().contains(bonusNumber)){
            return true;
        }

        return false;
    }


    public static List<Integer> creatRank(List<Integer> winStatistics, List<Boolean> bonusStatistics) {

        List<Integer> ranks = new ArrayList<>();

        for(int i = 0 ; i < winStatistics.size() ; i++){
            ranks.add(getRank(winStatistics.get(i), bonusStatistics.get(i)));
        }

        PrintUtil.printStatistics(ranks);
        return ranks;
    }

    private static Integer getRank(Integer winNumber, Boolean bonus) {

        int rank = 8;

        if(winNumber == 5 && bonus){
            winNumber++;
        }

        if(winNumber == 6){
            winNumber ++;
        }

        rank -= winNumber;

        return rank;
    }

    public static void calculateRevenue(List<Integer> ranks, int userLottoCnt) {

        int revenue = 0;

        for(int rank : ranks){
            revenue += getRevenueByRank(rank);
        }

        PrintUtil.printRevenue(revenue, userLottoCnt);
    }

    private static int getRevenueByRank(int rank) {
        if(rank == 1)   return 2000000000;
        if(rank == 2)   return 30000000;
        if(rank == 3)   return 1500000;
        if(rank == 4)   return 50000;
        if(rank == 5)   return 5000;

        return 0;
    }
}
