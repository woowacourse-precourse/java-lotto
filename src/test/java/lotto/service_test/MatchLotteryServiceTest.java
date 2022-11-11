package lotto.service_test;

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
        matchLotteryService = new MatchLotteryService();
    }

    @DisplayName("플레이어는 Long타입의 금액을 입력하면 생성해준다.")
    @Test
    void createPlayerByPaymentTest(){
        matchLotteryService.makePlayerLottoByPayment("8000");
        assertThat(matchLotteryService.getPlayer().getPlayerLotto().size()).isEqualTo(8);
    }

    @DisplayName("컴퓨터는 문자열로 로또 번호와 보너스 숫자를 입력받으면 리스트와 정수로 저장한다.")
    @Test
    void createComputerByNumbersTest(){
        matchLotteryService.saveComputerNumber("1, 2, 3, 4, 5 6", "7");
        assertThat(matchLotteryService.getComputer().getComputerNumber().getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(matchLotteryService.getComputer().getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("플레이어와 컴퓨터를 매치시키면 플레이어의 로또 당 당첨등수가 정해진다. ")
    @Test
    void matchPlayerWithComputerTest(){
        matchLotteryService.saveComputerNumber("1, 2, 3, 4, 5 6", "7");
        matchLotteryService.makePlayerLottoByPayment("8000");
        matchLotteryService.matchPlayerWithComputer();
        assertThat(matchLotteryService.getPlayer().showWinningStatistics()).containsKeys(THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_MATCH_WITH_BONUS, SIX_MATCH);
    }
}
