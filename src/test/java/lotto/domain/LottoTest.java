package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또에 주어진 숫자가 있는지 여부를 구한다.")
    void hasNumberTest(){
        //Given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int num = 7;
        //When
        boolean hasNumber = lotto.hasNumber(num);
        //Then
        assertThat(hasNumber).isFalse();
    }

    @Test
    @DisplayName("다른 로또와 일치하는 숫자 갯수를 구한다.")
    void getMatchCountTest(){
        //Given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto otherLotto = new Lotto(List.of(2,3,5,19,20,43));
        //When
        int matchCount = lotto.getMatchCount(otherLotto);
        //Then
        assertThat(matchCount).isEqualTo(3);

    }
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

    @DisplayName("로또 번호가 1~45사이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 99)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
