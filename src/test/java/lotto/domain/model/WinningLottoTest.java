package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.model.request.LottoNumberRequest;
import lotto.domain.model.request.LottoRequest;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void USER_INPUT_VALIDATION() {
        LottoNumberRequest lottoNumberRequest = new LottoNumberRequest(1);
        LottoRequest lottoRequest = new LottoRequest(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new WinningLotto(lottoRequest, lottoNumberRequest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호와 보너스번호와 겹칠 수 없습니다.");

    }

}