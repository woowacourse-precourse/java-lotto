package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;

import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoTicket {
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public LottoTicket(long count){
        generateTickets(count);
    }

    private void generateTickets(long count){
        for(int i=0;i<count;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottoTickets.add(new Lotto(numbers));

        }
    }

    public List<Lotto> getLottoTickets(){
        return lottoTickets;
    }

    public Result calculateStatistic(LuckyNumbers luckyNumbers){
        List<LottoRank> lottoRanks = lottoTickets.stream()
                .map(luckyNumbers::calculateRanking)
                .filter(Objects::nonNull)
                .collect(collectingAndThen(toList(),Collections::unmodifiableList));
        return new Result(lottoRanks);
    }

}
