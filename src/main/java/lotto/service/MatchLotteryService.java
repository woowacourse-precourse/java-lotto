package lotto.service;

import lotto.Ranking;
import lotto.domain.Lotto;
import lotto.model.Computer;
import lotto.model.Player;

import static lotto.Ranking.*;

public class MatchLotteryService {

    private final Player player;
    private final Computer computer;

    public MatchLotteryService(Player player, Computer computer){
        this.player= player;
        this.computer = computer;
    }

    public void matchPlayerWithComputer(){
        for(Lotto lottoEach : player.getPlayerLotto()){
            matchEachTicketWithComputer(lottoEach);
        }
    }

    private void matchEachTicketWithComputer(Lotto lottoEach){
        int equalCount = countContainingNumber(lottoEach);
        player.addLottoRanking(convertCountToRanking(lottoEach, equalCount));
    }

    private int countNumberIfContains(int numberEach){
        if(computer.getComputerNumber().getNumbers().contains(numberEach)) return 1;
        return 0;
    }

    private int countContainingNumber(Lotto lottoEach){
        int countingResult = 0;
        for(int  numberEach : lottoEach.getNumbers()){
            countingResult += countNumberIfContains(numberEach);
        }
        return countingResult;
    }

    private Ranking convertCountToRanking(Lotto lottoEach, int equalCount){
        if(equalCount == SIX_MATCH.getCountOfMatch()) return SIX_MATCH;
        if(equalCount == FIVE_MATCH.getCountOfMatch()) return separateByBonusNumber(lottoEach);
        if(equalCount == FOUR_MATCH.getCountOfMatch()) return FOUR_MATCH;
        if(equalCount == THREE_MATCH.getCountOfMatch()) return THREE_MATCH;
        return Ranking.NOTHING;
    }

    private Ranking separateByBonusNumber(Lotto lottoEach){
        if(lottoEach.getNumbers().contains(computer.getBonusNumber())) return FIVE_MATCH_WITH_BONUS;
        return FIVE_MATCH;
    }
}
