package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.common.constant.NumberConstant.LOTTO_BONUS_LENGTH;
import static lotto.domain.LottoResult.FOUR;
import static lotto.domain.LottoResult.THREE;
import static lotto.domain.LottoResult.FIVE;
import static lotto.domain.LottoResult.FIVE_BONUS;
import static lotto.domain.LottoResult.SIX;
import static lotto.domain.LottoResult.LOSING;

public class LottoStatistics {
    private static final int numberThree = 3;
    private static final int numberFour = 4;
    private static final int numberFive = 5;
    private static final int numberSix = 6;

    private static final int lottoSixNumber = 0;
    private static final int lottoBonusNumber = 1 ;

    private static final Map<LottoResult,Integer> lottoResultMap = new LinkedHashMap<>();

    public LottoStatistics(){
        initLottoResultMap();
    }

    private void initLottoResultMap(){
        lottoResultMap.put(THREE,0);
        lottoResultMap.put(FOUR,0);
        lottoResultMap.put(FIVE,0);
        lottoResultMap.put(FIVE_BONUS,0);
        lottoResultMap.put(SIX,0);
        lottoResultMap.put(LOSING,0);
    }

    public void calculation(List<Lotto> lottoTicketList, WinningNumbers winningNumbers){
        initLottoResultMap();
        for (Lotto lottoTicket : lottoTicketList) {
            LottoResult result = checkRanking(lottoTicket,winningNumbers);
            lottoResultMap.replace(result,lottoResultMap.get(result) + 1);
        }
    }

    private LottoResult checkRanking(Lotto oneLottoTicket, WinningNumbers winningNumbers){
        List<Integer> lottoTicket = oneLottoTicket.get();
        List<Integer> winningSixNumbers = winningNumbers.getWinNumbers();
        int winningBonusNumber = winningNumbers.getBonus();
        List<Integer> count  = new ArrayList<>(Arrays.asList(lottoSixNumber,0));
        for (Integer number : lottoTicket) count = countContain(number,winningSixNumbers,winningBonusNumber,count);
        return findRanking(count,oneLottoTicket);
    }

    public List<Integer> countContain(int number, List<Integer> winningSixNumbers, int winningBonusNumber, List<Integer> count){
        if (winningSixNumbers.contains(number)) count.set(lottoSixNumber,count.get(lottoSixNumber)+1);
        else if (number == winningBonusNumber) count.set(lottoBonusNumber,1);
        return count;
    }

    protected LottoResult findRanking(List<Integer> count, Lotto oneLottoTicket){
        if (count.get(lottoSixNumber)+count.get(lottoBonusNumber) == numberThree) oneLottoTicket.setLottoResult(THREE);
        else if (count.get(lottoSixNumber)+count.get(lottoBonusNumber) == numberFour) oneLottoTicket.setLottoResult(FOUR);
        else if (count.get(lottoSixNumber)+count.get(lottoBonusNumber) == numberFive) oneLottoTicket.setLottoResult(FIVE);
        else if (count.get(lottoSixNumber) == numberSix) oneLottoTicket.setLottoResult(SIX);
        else if (count.get(lottoSixNumber)==numberFive && count.get(lottoBonusNumber)== LOTTO_BONUS_LENGTH) oneLottoTicket.setLottoResult(FIVE_BONUS);
        return oneLottoTicket.getLottoResult();
    }

    public List<Integer> getLottoStatisticsList(){
        List<Integer> lottoStatisticsList = new ArrayList<>();
        for ( LottoResult key : lottoResultMap.keySet() ) {
            lottoStatisticsList.add(lottoResultMap.get(key));
        }
        return lottoStatisticsList;
    }

    public static Map<LottoResult,Integer> getLottoResultMap(){
        return lottoResultMap;
    }


}
