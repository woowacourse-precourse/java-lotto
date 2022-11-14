package lotto;

import lotto.Dto.Lotto;
import lotto.Dto.Money;
import lotto.Services.CalculatedService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("돈이 숫자가 아니면 예외가 발생한다")
    @Test
    void createLottoBuyMoney() {
        assertThatThrownBy(() -> new Money("하이"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈이 1000원 단위로 들어오는지 확인한다.")
    @Test
    void createLottoSize() {
        assertThatThrownBy(() -> new CalculatedService().lottoSize(new Money("4050")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("형식에 맞게 입력이 들어오는지 확인한다.")
    @Test
    void creatWinningNumbers() {
        assertThatThrownBy(() -> new Lotto("1, 2, 3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
