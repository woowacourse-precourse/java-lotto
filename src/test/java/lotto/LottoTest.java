package lotto;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 보너스 숫자까지 포함해 7개 번호가 일치하면 1등이다.")
    @Test
    void winLottoBySevenNumber() {

    }

    @DisplayName("로또 번호의 6개 번호가 일치하면 1등이다.")
    @Test
    void winLottoBySixNumber() {

    }

    @DisplayName("로또 번호의 5개 번호가 일치하고 보너스 번호가 일치하면 2등이다.")
    @Test
    void winLottoByFiveNumberAndBonusNumber() {

    }


    @DisplayName("로또 번호의 5개 번호만 일치하면 3등이다.")
    @Test
    void winLottoByFiveCorrectNumber() {

    }

    @DisplayName("로또 번호의 4개 번호만 일치하면 4등이다.")
    @Test
    void winLottoByFourCorrectNumber() {

    }


    @DisplayName("로또 번호의 3개 번호만 일치하면 5등이다.")
    @Test
    void winLottoByThreeCorrectNumber() {

    }

    @DisplayName("로또 번호의 2개 번호만 일치하면 낙첨이다.(0)")
    @Test
    void loseLottoByTwoCorrectNumber() {

    }

    @DisplayName("로또 번호의 1개 번호만 일치하면 낙첨이다.(0)")
    @Test
    void loseLottoByOneCorrectNumber() {

    }


    @DisplayName("로또 번호 중 아무것도 일치하지 않으면 낙첨이다.(0)")
    @Test
    void loseLottoByNonCorrectNumber() {

    }


}

