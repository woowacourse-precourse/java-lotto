package player;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;



class CoinErrorCheckTest {

    @Test
    void 예외_테스트() {
    	int coin = 13001;
    	
    	CoinErrorCheck.CEC(coin);
    	IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> CoinErrorCheck.CEC(coin));
    	assertThat(e.getMessage()).isEqualTo("[Error] 투입 금액은 1000의 배수여야 합니다");
    }
}
