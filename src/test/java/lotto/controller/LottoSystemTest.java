package lotto.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSystemTest {
    LottoSystem lottoSystem = new LottoSystem();

    @DisplayName("로또 번호 당첨 개수 구하기")
    @Test
    public void createResult() {
        //given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        //when
        int expected = lottoSystem.calculateLotto(lotto, winningLotto);
        //then
        assertThat(expected).isEqualTo(5);
    }

    @DisplayName("입력 받은 금액만큼 로또 수량 출력")
    @Test
    public void createLottoQuantity() {
        //given
        int userMoney = 5000;
        //when
        int quantity = lottoSystem.LottoQuantityCalculation(userMoney);
        //then
        assertThat(quantity).isEqualTo(5);
    }
    
    @DisplayName("로또 수량만큼 로또가 생성되는지 확인")
    @Test
    public void createLottos() {
        //given
        int quantity = 5;
        //when
        UserLotto userLotto = lottoSystem.makeUserLottos(quantity);
        //then
        assertThat(userLotto.getSize()).isEqualTo(5);
    }

}