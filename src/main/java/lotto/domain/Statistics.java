package lotto.domain;

import lotto.generate.BuyerGenerate;
import lotto.generate.WinLottoGenerate;
import lotto.output.LottoRandomPeekOutput;
import lotto.output.StatisticsOutput;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Statistics {
    private final int LOTTO_SIZE = 6;
    private final int BONUS_INDEX = LOTTO_SIZE+2;
    private final List<Integer> reward = List.of(5000,50000,1500000,2000000000,30000000);
    private final List<Integer> rank = new ArrayList<>(Collections.nCopies(BONUS_INDEX,0));
    private final int randomlottosize;
    public Statistics(List<Lotto> randomLottos) {
        randomlottosize = randomLottos.size();
    }
    public void compareNumber(List<Lotto> randomLottos, WinLotto winLotto){
        List<Integer> winNumbers = winLotto.getWinNumbers().stream().limit(LOTTO_SIZE).collect(Collectors.toList());
        int bonus = winLotto.getWinNumbers().get(LOTTO_SIZE);
        for(Lotto tmpLotto : randomLottos){
            int countMatch = 0;
            List<Integer> tmpNumber = tmpLotto.getNumbers();
            for(int winNumber : winNumbers)if(tmpNumber.contains(winNumber))countMatch++;
            if(countMatch ==5 )checkHasBonus(bonus, countMatch, tmpNumber);
            if(countMatch!=5)rank.set(countMatch, rank.get(countMatch)+1);
        }
    }

    private void checkHasBonus(int bonus, int count, List<Integer> tmpNumber) {
        if(tmpNumber.contains(bonus)){
            rank.set(BONUS_INDEX,rank.get(BONUS_INDEX)+1);
        }
        if(!tmpNumber.contains(bonus)){
            rank.set(count,rank.get(count)+1);
        }
    }
}
