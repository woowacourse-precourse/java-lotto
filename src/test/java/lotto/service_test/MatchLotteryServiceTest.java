package lotto.service_test;

import lotto.model.Computer;
import lotto.model.Player;
import lotto.service.MatchLotteryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Ranking.*;
import static org.assertj.core.api.Assertions.*;
public class MatchLotteryServiceTest {

    MatchLotteryService matchLotteryService;

    @BeforeEach
    void initializeClass(){
        Player player = new Player();
        player.buyTickets(8000);
        Computer computer = new Computer();
        computer.saveWinningTicket("1,2,3,4,5,6,");
        computer.saveBonusNumber("7");
        matchLotteryService = new MatchLotteryService(player, computer);
    }

    @DisplayName("플레이어와 컴퓨터를 매치시키면 플레이어의 로또 당 당첨등수가 정해진다. ")
    @Test
    void matchPlayerWithComputerTest(){
        matchLotteryService.matchPlayerWithComputer();
        assertThat(matchLotteryService.getPlayer().showWinningStatistics()).containsKeys(THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_MATCH_WITH_BONUS, SIX_MATCH);
    }
}
