package lotto.model_test;

import lotto.Ranking;
import lotto.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void initializeClass(){
        player = new Player();
    }

    @Test
    @DisplayName("로또 구매 금액을 입력하면 금액/1000개 만큼의 로또를 저장한다. ")
    void buyTicketTest(){
        player.buyTickets(10000);
        assertThat(player.getPlayerLotto().size()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또의 등수들을 해시맵으로 리턴해준다. ")
    void showWinningStatisticsTest(){
        addRankings();
        assertThat(player.showWinningStatistics()).isEqualTo(createTester());
    }

    @Test
    @DisplayName("로또 구매금액과 당첨금액을 이용해 수익률 백분율 소수점 첫째자리까지 알려준다. ")
    void getPlayersProfitTest(){
        player.buyTickets(5000);
        addRankings();
        assertThat(player.showWinningProfit()).isEqualTo(40030300);
    }


    private void addRankings(){
        player.addLottoRanking(Ranking.THREE_MATCH);
        player.addLottoRanking(Ranking.THREE_MATCH);
        player.addLottoRanking(Ranking.THREE_MATCH);
        player.addLottoRanking(Ranking.FIVE_MATCH_WITH_BONUS);
        player.addLottoRanking(Ranking.FIVE_MATCH);
    }

    private HashMap<Ranking, Integer> createTester(){
        HashMap<Ranking, Integer> tester = new HashMap<>();
        tester.put(Ranking.THREE_MATCH, 3);
        tester.put(Ranking.FIVE_MATCH_WITH_BONUS, 1);
        tester.put(Ranking.FIVE_MATCH, 1);
        return tester;
    }
}
