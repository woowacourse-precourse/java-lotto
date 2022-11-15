package lotto;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private LottoService lottoService = LottoService.getInstance();
    private LottoRepository lottoRepository = LottoRepository.getInstance();

    @DisplayName("입력받은 금액만큼의 로또 생성 수를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000","2000","124000"})
    void getTheNumberOfLotto(String inputMoney) {
        Money money = lottoService.getTheNumberOfLotto(inputMoney);
        assertThat(money.getTheNumberOfLotto()).isEqualTo(Integer.parseInt(inputMoney)/1000);
    }

    @DisplayName("로또 수만큼의 로또를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void createUserLotto(Integer count) {
        List<Lotto> lottoGroup = lottoService.createUserLotto(count);
        assertThat(lottoGroup.size()).isEqualTo(count);
    }

    @DisplayName("입력받은 당첨 번호의 로또를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void createWinningLotto(String winningNumber) {
        List<Integer> result = lottoService.transferToNumbers(winningNumber);
        assertThat(result.size()).isEqualTo(6);
    }

    @DisplayName("로또 당첨 결과에 따라 수익률을 계산한다.")
    @Test
    void getProfit() {
        String profit = lottoService.calculateProfit(List.of(0,0,0,1,0,0,0,0),8000.0);
        assertThat(profit).isEqualTo("62.5");
    }
}