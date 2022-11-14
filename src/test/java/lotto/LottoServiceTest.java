package lotto;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.service.LottoService;
import lotto.system.SystemMessage;
import lotto.system.SystemValid;
import lotto.type.ErrorType;
import lotto.type.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @DisplayName("사용자 금액이 로또금액으로 나누어지지 떨어지지 않는 다면 예외가 발생한다.")
    @Test
    void createdLottoServiceByMoneyDivideLottoPrice() {
        assertThatThrownBy(() -> lottoService.buy(2300))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 금액 0원이라면 예외가 발생한다.")
    @Test
    void createdLottoServiceByMoneyZero() {
        assertThatThrownBy(() -> lottoService.buy(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 입력 금액이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createdSystemValidByValidateNumber() {
        assertThatThrownBy(() -> SystemValid.validateForNumber("1000asw", ErrorType.MONEY))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 입력 정답 번호를 리스트로 변환되는 지")
    @Test
    void createdLottoServiceByInputParseToList() {
        List<Integer> winningNumbersOfSix = lottoService.winningInputParseToList("1,2,3,4,5,6");
        List<Integer> winningNumbersOfTree = lottoService.winningInputParseToList("1,2,3");
        assertThat(winningNumbersOfSix).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningNumbersOfTree).isEqualTo(List.of(1, 2, 3));
    }

    @DisplayName("로또 당첨 내역 출력 정상적으로 나오는 지")
    @Test
    void createdSystemMessageByWinningHistory() {
        OutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        SystemMessage.winningHistory(List.of(Rank.FIVE, Rank.NONE, Rank.FIVE, Rank.THREE, Rank.TWO));

        assertThat(captor.toString().trim()).contains(
                "3개 일치 (5,000원) - 2개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 0개"
        );
    }

    @DisplayName("수익률이 62.5%가 나오는 지")
    @Test
    void createdLottoServiceByPortfolioNormal() {
        List<Rank> lottosRank = List.of(Rank.FIVE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE,
                Rank.NONE);
        double portfolio = lottoService.calculatePortfolio(lottosRank, 8000);
        assertThat(String.format("%.1f", portfolio)).isEqualTo("62.5");

    }

    @DisplayName("수익률이 0.0%가 나오는 지")
    @Test
    void createdLottoServiceByPortfolioZero() {
        List<Rank> lottosRank = List.of(Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE);
        double portfolio = lottoService.calculatePortfolio(lottosRank, 4000);
        assertThat(String.format("%.1f", portfolio)).isEqualTo("0.0");
    }

}
