package lotto;

import lotto.domain.BuyLotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BuyLottoTest {
    private BuyLotto buyLotto;

    @BeforeEach
    void 생성자(){
        buyLotto = new BuyLotto();
    }

    @Test
    void 로또_수_테스트(){
        buyLotto.createLottos(3);
        assertThat(buyLotto.getLottos().size()).isEqualTo(3);
    }

}
