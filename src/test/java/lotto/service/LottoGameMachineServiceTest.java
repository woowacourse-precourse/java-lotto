package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.enumeration.Rating;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.*;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

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

    @DisplayName("당첨 번호가 입력되어야 한다.")
    @Test
    public void givenWinningNumbers_whenEnterWinningNumbers_thenReturnWinningNumbers(){
        // Given
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        Lotto winningNumbersLotto = new Lotto(winningNumbers);

        // When
        service.enterTheWinningNumbers(winningNumbersLotto);

        // Then
        assertThat(service.readWinningNumbers()).hasSize(6);
        assertThat(service.readWinningNumbers()).isEqualTo(winningNumbers);
    }

    @DisplayName("보너스 번호가 입력되어야 한다.")
    @Test
    public void givenBonusNumber_whenEnterBonusNumber_thenReturnBonusNumber(){
        // Given
        int bonusNumber = 1;

        // When
        service.enterBonusNumber(bonusNumber);

        // Then
        assertThat(service.readBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("통계를 계산해야 한다. [다 맞을 경우]")
    @Test
    public void givenMoney_LottoNumber_whenCalculateStatistics_thenReturnRatingFirst(){
        // Given
        service.enterMoney(1000);
        Lotto lotto = service.readLottoNumbers().get(0);
        service.enterTheWinningNumbers(lotto);
        service.enterBonusNumber(10);

        // When
        LinkedHashMap<Rating, Integer> rating = service.calculateStatistics();

        // Then
        assertThat(rating.get(Rating.FIRST)).isEqualTo(1);
    }

    @AfterAll
    public static void afterAll(){
        service = null;
    }
}