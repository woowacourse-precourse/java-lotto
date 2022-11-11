package lotto;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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
        assertThatThrownBy(() -> new Money("100"))
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

    @DisplayName("당첨 번호 입력시 중복이면 예외 발생")
    @Test
    void inputWinningNumberByDuplicate(){
        InputStream in = new ByteArrayInputStream("1,2,3,4,5,5".getBytes());
        System.setIn(in);

        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.inputWinningLottoNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개가 넘어가면 예외 발생")
    @Test
    void inputWinningNumberByOverSize(){
        InputStream in = new ByteArrayInputStream("1,2,3,4,5,6,7".getBytes());
        System.setIn(in);

        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.inputWinningLottoNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생")
    @Test
    void bonusNumberRangeTest(){
        LottoService lottoService = new LottoService();
        int bonusNumber = 46;
        assertThatThrownBy(() -> lottoService.validateBonusNumberRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되는 값이면 예외발생")
    @Test
    void bonusNumberDuplicateWithWinningNumber(){
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 6;
        assertThatThrownBy(() -> new WinningLotto(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
