package lotto.repository;

import lotto.domain.Lotto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoRepositoryTest {
    static LottoRepository repository;

    @BeforeAll
    public static void beforeAll(){
        repository = new LottoRepository();
    }

    @DisplayName("금액을 저장하는 동시에 로또 개수와 로또 각각의 숫자가 발행되어 저장한다.")
    @Test
    public void givenMoney_whenPayMoney_thenSaveMoney_LottoQuantity_LottoNumbers(){
        // Given
        int money = 8000;

        // When
        repository.saveMoney(money);

        // Then
        assertThat(repository.getMoney()).isEqualTo(8000);
        assertThat(repository.getLottoQuantity()).isEqualTo(8);
        assertThat(repository.getLottoNumbers().size()).isEqualTo(8);
    }

    @DisplayName("당첨 번호가 저장이 된다.")
    @Test
    public void givenWinningNumbers_whenSaveWinningNumbers_thenReturnWinningNumbers(){
        // Given
        List<Integer> lottoNumber = new ArrayList<>(List.of(1,2,3,4,5,6));
        Lotto winningNumbers = new Lotto(lottoNumber);

        // When
        repository.saveWinningNumbers(winningNumbers);

        // Then
        assertThat(repository.getWinningNumbers().size()).isEqualTo(6);
        assertThat(repository.getWinningNumbers()).isEqualTo(lottoNumber);
    }

    @DisplayName("보너스 번호가 저장이 된다.")
    @Test
    public void givenBonusNumber_whenSaveBonusNumber_thenReturnBonusNumber(){
        // Given
        int bonusNumber = 1;

        // When
        repository.saveBonusNumber(bonusNumber);

        // Then
        assertThat(repository.getBonusNumber()).isEqualTo(1);
    }

    @AfterAll
    public static void afterAll(){
        repository = null;
    }
}