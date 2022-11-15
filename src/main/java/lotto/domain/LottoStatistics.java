package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoResult.THREE;
import static lotto.domain.LottoResult.FOUR;
import static lotto.domain.LottoResult.FIVE;
import static lotto.domain.LottoResult.FIVE_BONUS;
import static lotto.domain.LottoResult.SIX;
import static lotto.domain.LottoResult.LOSING;
import static lotto.domain.LottoResult.fromBonus;
import static lotto.domain.LottoResult.fromSix;

public class LottoStatistics {
    private static final int numberThree = 3;
    private static final int numberFive = 5;

    private static final int lottoSixNumber = 0;
    private static final int lottoBonusNumber = 1;

    private static final int initZero = 0;

    private static final Map<LottoResult,Integer> lottoResultMap = new LinkedHashMap<>();

    public LottoStatistics(){
        initLottoResultMap();
    }

    private void initLottoResultMap(){
        lottoResultMap.put(THREE,initZero);
        lottoResultMap.put(FOUR,initZero);
        lottoResultMap.put(FIVE,initZero);
        lottoResultMap.put(FIVE_BONUS,initZero);
        lottoResultMap.put(SIX,initZero);
        lottoResultMap.put(LOSING,initZero);
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
        List<Integer> count  = new ArrayList<>(Arrays.asList(initZero,initZero));
        for (Integer number : lottoTicket) count = countContain(number,winningSixNumbers,winningBonusNumber,count);
        return findRanking(count,oneLottoTicket);
    }

    public List<Integer> countContain(int number, List<Integer> winningSixNumbers, int winningBonusNumber, List<Integer> count){
        if (winningSixNumbers.contains(number)) {
            count.set(lottoSixNumber,count.get(lottoSixNumber)+1);
        }
        if (number == winningBonusNumber) {
            count.set(lottoBonusNumber,1);
        }
        return count;
    }

    public LottoResult findRanking(List<Integer> count, Lotto oneLottoTicket){
        if (count.get(lottoSixNumber) == numberFive){
            oneLottoTicket.setLottoResult(fromBonus(count.get(lottoBonusNumber)));
        }
        if (count.get(lottoSixNumber) >= numberThree && count.get(lottoSixNumber) != numberFive){
            oneLottoTicket.setLottoResult(fromSix(count.get(lottoSixNumber)));
        }
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
