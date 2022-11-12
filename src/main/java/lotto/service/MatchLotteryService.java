package lotto.service;

import lotto.Ranking;
import lotto.domain.Lotto;
import lotto.model.Computer;
import lotto.model.Player;

public class MatchLotteryService {

    private static final int THREE_MATCH = 3;
    private static final int FOUR_MATCH = 4;
    private static final int FIVE_MATCH = 5;
    private static final int SIX_MATCH = 6;

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
        int equalCount = (int)lottoEach.getNumbers().stream().map( s ->computer.getComputerNumber().getNumbers().contains(s)).count();
        player.addLottoRanking(convertCountToRanking(lottoEach, equalCount));
    }

    private Ranking convertCountToRanking(Lotto lottoEach, int equalCount){
        if(equalCount == THREE_MATCH) return Ranking.THREE_MATCH;
        if(equalCount == FOUR_MATCH) return Ranking.FOUR_MATCH;
        if(equalCount == FIVE_MATCH) return separateByBonusNumber(lottoEach);
        if(equalCount == SIX_MATCH) return Ranking.SIX_MATCH;
        return Ranking.NOTHING;
    }

    private Ranking separateByBonusNumber(Lotto lottoEach){
        if(lottoEach.getNumbers().contains(computer.getBonusNumber())) return Ranking.FIVE_MATCH_WITH_BONUS;
        return Ranking.FIVE_MATCH;
    }
}
