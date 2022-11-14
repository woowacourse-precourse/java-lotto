package lotto.service;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.*;


import static org.assertj.core.api.Assertions.*;

class LottoGameMachineServiceTest {

    static LottoGameMachineService service;

    @BeforeEach
    public void beforeEach(){
        service = new LottoGameMachineServiceImpl();
    }

    @DisplayName("금액을 입력하면 저장함과 동시에 로또의 개수, 로또 번호가 발행되어야 한다.")
    @Test
    public void givenMoney_whenEnterMoney_thenReturnMoney(){
        // Given
        int money = 8000;
        int lottoQuantity = money / 1000;

        // When
        service.enterMoney(money);

        // Then
        assertThat(service.readMoney()).isEqualTo(money);
        assertThat(service.readLottoQuantity()).isEqualTo(lottoQuantity);
        assertThat(service.readLottoNumbers()).hasSize(lottoQuantity);
    }
}