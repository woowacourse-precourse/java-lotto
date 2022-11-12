package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("발행된 하나의 로또의 숫자는 1 ~ 45의 값을 갖는 6개의 중복되지 않는 숫자이다.")
    @Test
    void createLottoByRangeNumber() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> lotto = lottoMachine.getLottoNumber();

        assertThat(lotto.size()).isEqualTo(6);
        assertThat(lotto).doesNotHaveDuplicates();

        lotto.stream().forEach(
                (number) -> Assertions.assertTrue(1 <= number && number <= 45)
        );
    }

    @DisplayName("여러 개의 로또를 구매할 수 있다.")
    @Test
    void createLottoByCount() {
        long purchaseCount = 8L;
        LottoMachine lottoMachine = new LottoMachine();

        List<Lotto> lottoNumbers = lottoMachine.issueLottoNumbers(purchaseCount);

        assertThat(lottoNumbers.size()).isEqualTo(purchaseCount);

        lottoNumbers.stream().forEach(
                (lottoNumber) -> assertThat(lottoNumber.getLotto())
                        .doesNotHaveDuplicates()
        );
    }

    @DisplayName("주어진 당첨 번호를 저장한다.")
    @Test
    void saveWinNumber() {
        LottoMachine lottoMachine = new LottoMachine();

        List<String> inputWinNumber = List.of("1", "2", "3", "4", "5", "6");
        lottoMachine.setWinNumber(inputWinNumber);

        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).getLotto()).isEqualTo(lottoMachine.winNumber.getLotto());

    }

    @DisplayName("잘못된 당첨 번호가 주어지면 예외가 발생한다.")
    @Test
    void giveWrongWinNumber() {

        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.setWinNumber(List.of("1", "2", "3", "4", "5", "6", "7")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoMachine.setWinNumber(List.of("1", "2", "2", "3", "4", "5")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoMachine.setWinNumber(List.of(" ", " ", " ", " ", " ", " ")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주어진 보너스 번호를 저장한다.")
    @Test
    void saveBonusNumber() {

        LottoMachine lottoMachine = new LottoMachine();

        lottoMachine.setWinNumber(List.of("1", "2", "3", "4", "5", "6"));
        lottoMachine.setBonusNumber("7");

        assertThat(lottoMachine.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("잘못된 보너스 번호가 주어지면 예외가 발생한다.")
    @Test
    void giveWrongBonusNumber() {

        LottoMachine lottoMachine = new LottoMachine();

        lottoMachine.setWinNumber(List.of("1", "2", "3", "4", "5", "6"));

        assertThatThrownBy(() -> lottoMachine.setBonusNumber("3"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoMachine.setBonusNumber("100"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoMachine.setBonusNumber("1111111111111111111111111111111111111111"))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
