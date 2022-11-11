package lotto.domain;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.constant.NumberConstant.GET_FIRST_RANKING_PRIZE;
import static lotto.constant.NumberConstant.GET_SECOND_RANKING_PRIZE;
import static lotto.constant.NumberConstant.GET_THIRD_RANKING_PRIZE;
import static lotto.constant.NumberConstant.GET_FOURTH_RANKING_PRIZE;
import static lotto.constant.NumberConstant.GET_FIFTH_RANKING_PRIZE;
import static lotto.constant.NumberConstant.LOTTO_BONUS_LENGTH;
import static lotto.domain.LottoResult.FOUR;
import static lotto.domain.LottoResult.THREE;
import static lotto.domain.LottoResult.FIVE;
import static lotto.domain.LottoResult.FIVE_BONUS;
import static lotto.domain.LottoResult.SIX;
import static lotto.domain.LottoResult.LOSING;

public class LottoStatistics {

    private static final Map<LottoResult,Integer> lottoResultMap = new LinkedHashMap<>();
    private static void initLottoResultMap(){
        lottoResultMap.put(THREE,0);
        lottoResultMap.put(FOUR,0);
        lottoResultMap.put(FIVE,0);
        lottoResultMap.put(FIVE_BONUS,0);
        lottoResultMap.put(SIX,0);
        lottoResultMap.put(LOSING,0);
    }

    public static void calculation(List<Lotto> lottoTicketList, WinningNumbers winningNumbers){
        initLottoResultMap();
        for (Lotto lottoTicket : lottoTicketList) {
            LottoResult result = checkRanking(lottoTicket,winningNumbers);
            lottoResultMap.replace(result,lottoResultMap.get(result) + 1);
        }
    }

    private static LottoResult checkRanking(Lotto oneLottoTicket, WinningNumbers winningNumbers){
        List<Integer> lottoTicket = oneLottoTicket.get();
        List<Integer> winningSixNumbers = winningNumbers.getWinNumbers();
        int winningBonusNumber = winningNumbers.getBonus();
        List<Integer> count  = new ArrayList<>(Arrays.asList(0,0));
        for (Integer number : lottoTicket) count = countContain(number,winningSixNumbers,winningBonusNumber,count);
        return findRanking(count,oneLottoTicket);
    }

    private static List<Integer> countContain(int number, List<Integer> winningSixNumbers, int winningBonusNumber, List<Integer> count){
        if (winningSixNumbers.contains(number)) count.set(0,count.get(0)+1);
        else if (number == winningBonusNumber) count.set(1,1);
        return count;
    }
    
    private static LottoResult findRanking(List<Integer> count, Lotto oneLottoTicket){
        if (count.get(0)+count.get(1) == 3) oneLottoTicket.setLottoResult(THREE);
        else if (count.get(0)+count.get(1) == 4) oneLottoTicket.setLottoResult(FOUR);
        else if (count.get(0)+count.get(1) == 5) oneLottoTicket.setLottoResult(FIVE);
        else if (count.get(0) == 6) oneLottoTicket.setLottoResult(SIX);
        else if (count.get(0)==5 && count.get(1)== LOTTO_BONUS_LENGTH) oneLottoTicket.setLottoResult(FIVE_BONUS);
        return oneLottoTicket.getLottoResult();
    }

    public static List<Integer> getLottoStatisticsList(){
        List<Integer> lottoStatisticsList = new ArrayList<>();
        for ( LottoResult key : lottoResultMap.keySet() ) {
            lottoStatisticsList.add(lottoResultMap.get(key));
        }
        return lottoStatisticsList;
    }

    public static float calculateEarning(int lottoPrice){
        return ((float)addPrize()/(float)lottoPrice) *100;
    }

    private static int addPrize(){
        int total = 0;
        for ( LottoResult key : lottoResultMap.keySet() ) {
            if (key == THREE) total+= GET_FIFTH_RANKING_PRIZE * lottoResultMap.get(key);
            else if (key == FOUR) total += GET_FOURTH_RANKING_PRIZE * lottoResultMap.get(key);
            else if (key == FIVE) total += GET_THIRD_RANKING_PRIZE * lottoResultMap.get(key);
            else if (key == FIVE_BONUS) total += GET_SECOND_RANKING_PRIZE * lottoResultMap.get(key);
            else if (key == SIX) total += GET_FIRST_RANKING_PRIZE * lottoResultMap.get(key);
        }
        return total;
    }

}
