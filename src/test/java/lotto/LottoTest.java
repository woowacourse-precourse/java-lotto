package lotto;

import lotto.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    @DisplayName("구입 금액에 숫자가 없으면 예외 처리")
    @Test
    void 로또_구입_글자입력() {
        assertThatThrownBy(() -> new MoneyToAmount(("2000j"))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외 처리")
    @Test
    void 로또_구입_1000원단위_x() {
        assertThatThrownBy(() -> new MoneyToAmount(("2500"))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 금액 입력 시 올바른 amount를 반환")
    @Test
    void 로또_구입_o() {
        MoneyToAmount moneyToAmount = new MoneyToAmount("8000");
        Assertions.assertThat(moneyToAmount.getAmount()).isEqualTo(8);
    }

    @DisplayName("로또 번호 발급")
    @Test
    void 로또_발급() {
        Lotto lotto = new Lotto(LottoNumbers.generateNumber());
    }

    @DisplayName("로또 발급 후 로또 리스트에 추가")
    @Test
    void 로또리스트에_추가() {
        LottoList lottoList = new LottoList();
        Lotto lotto = new Lotto(LottoNumbers.generateNumber());
        lottoList.addLottoList(lotto);
    }

    @DisplayName("로또 발급")
    @Test
    void 로또_발급받기() {
        IssuedLotto issuedLotto = new IssuedLotto(8);
    }

    @DisplayName("당첨번호 입력처리")
    @Test
    void 올바른_값_입력() {
        InputProcessing inputProcessing = new InputProcessing();
        List numberList = inputProcessing.inputConverter("1,2,3,4,5,6");
    }

    @DisplayName("당첨번호 입력 예외처리")
    @Test
    void 잘못된_값_입력() {
        InputProcessing inputProcessing = new InputProcessing();
        assertThatThrownBy(() -> inputProcessing.inputConverter("1,2,3,4,kk")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputProcessing.inputConverter("ab,1,2,3,4,5")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력 후 로또 객체에 입력")
    @Test
    void 당청_번호_입력(){
        InputProcessing inputProcessing = new InputProcessing();
        Lotto lotto = new Lotto(inputProcessing.inputConverter("1,2,3,4,5,6"));
        assertThatThrownBy(() -> new Lotto(inputProcessing.inputConverter("1,2,0,46,47,48"))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(inputProcessing.inputConverter("1,1,2,3,4,5"))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(inputProcessing.inputConverter("1,2,3,4,5"))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(inputProcessing.inputConverter("1,2,3,4,5,6,7"))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 정상 값 예외 값 입력")
    @Test
    void 보너스_번호_입력() {
        BonusNumber bonusNumber = new BonusNumber("1");
        assertThatThrownBy(() -> new BonusNumber("a")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BonusNumber("0")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BonusNumber("46")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BonusNumber("11a")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BonusNumber("1,2,3")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력")
    @Test
    void 당첨번호_보너스번호_입력() {
        List<Integer> numberList = new ArrayList<>();
        InputProcessing inputProcessing = new InputProcessing();
        numberList = inputProcessing.inputConverter("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("45");
        WinningLotto winningLotto = new WinningLotto(new Lotto(numberList), bonusNumber);
    }

    @DisplayName("보너스 번호 중복 검사")
    @Test
    void 당첨번호_보너스번호_중복검사예외() {
        List<Integer> numberList = new ArrayList<>();
        InputProcessing inputProcessing = new InputProcessing();
        numberList = inputProcessing.inputConverter("1,2,3,4,5,6");
        Lotto lotto = new Lotto(numberList);
        BonusNumber bonusNumber = new BonusNumber("6");
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}
