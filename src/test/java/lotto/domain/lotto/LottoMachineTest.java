package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    
    LottoMachine lottoMachine;
    
    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }
    
    @Test
    void buy_메소드는_구입_금액을_로또_가격으로_나눈_사이즈의_로또_인스턴스_리스트_반환_1() {
        int amount = 1000;
        assertThat(lottoMachine.buy(amount).size()).isEqualTo(amount / LottoMachine.LOTTO_PRICE);
    }
    
    @Test
    void buy_메소드는_구입_금액을_로또_가격으로_나눈_사이즈의_로또_인스턴스_리스트_반환_2() {
        int amount = 26000;
        assertThat(lottoMachine.buy(amount).size()).isEqualTo(amount / LottoMachine.LOTTO_PRICE);
    }
    
    @Test
    void buy_메소드는_로또_금액_단위에_맞아_떨어지지_않을_경우_IllegalArgumentException_예외를_발생() {
        int amount = 25555;
        assertThatThrownBy(() -> lottoMachine.buy(amount)).isInstanceOf(IllegalArgumentException.class);
    }
}
