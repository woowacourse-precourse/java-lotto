package lotto.service;

import lotto.Lotto;
import lotto.repository.LottoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    private LottoService lottoService = new LottoService();

    @DisplayName("입력받은 금액만큼의 로또 생성 수를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000","2000","124000"})
    void getTheNumberOfLotto(String money) {
        Integer numberOfLotto = lottoService.getTheNumberOfLotto(money);
        assertThat(numberOfLotto).isEqualTo(Integer.parseInt(money)/1000);
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
        lottoService.createWinningLotto(winningNumber);
        assertThat(LottoRepository.getLastWinningLotto().getNumbers().size()).isEqualTo(6);
    }

    @Test
    void compareLotto() {
    }

    @Test
    void getWinningAmount() {
    }

    @Test
    void getProfit() {
    }
}