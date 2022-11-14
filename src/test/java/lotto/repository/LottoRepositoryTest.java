package lotto.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        repository.payMoney(money);

        // Then
        assertThat(repository.getMoney()).isEqualTo(8000);
        assertThat(repository.getLottoQuantity()).isEqualTo(8);
        assertThat(repository.getLottoNumbers().size()).isEqualTo(8);
    }

}