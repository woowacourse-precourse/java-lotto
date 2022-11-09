package lotto;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
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

    @DisplayName("입력 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void creatMoneyByWrongUnit() {
        assertThatThrownBy(() -> new Money().insertMoney(100))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("입력 금액의 단위에 맞는 개수의 로또 생성")
    @Test
    void creatLottosSizeCheck(){
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = lottoService.purchaseLottos(5);
        assertThat(lottos.size())
                .isEqualTo(5);
    }

    @DisplayName("당첨 번호 입력시 당첨 로또 생성")
    @Test
    void creatWinningLotto(){
        InputStream in = new ByteArrayInputStream("1,2,3,4,5,6".getBytes());
        System.setIn(in);

        LottoService lottoService = new LottoService();
        Lotto winningLotto = lottoService.getWinningLotto();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(winningLotto.toString())
                .isEqualTo(lotto.toString());
    }
}
