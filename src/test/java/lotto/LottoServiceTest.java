package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.service.LottoService;
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

    @DisplayName("사용자 입력 정답 번호를 리스트로 변환되는 지 - 1")
    @Test
    void createdLottoServiceByInputParseToList(){
        List<Integer> winningNumbersOfSix = lottoService.winningInputParseToList("1,2,3,4,5,6");
        List<Integer> winningNumbersOfTree = lottoService.winningInputParseToList("1,2,3");
        assertThat(winningNumbersOfSix).isEqualTo(List.of(1,2,3,4,5,6));
        assertThat(winningNumbersOfTree).isEqualTo(List.of(1,2,3));
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
