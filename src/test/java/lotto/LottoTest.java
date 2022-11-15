package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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
    @DisplayName("출력용 문자열을 생성한다.")
    @Test
    void generateString() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(list);

        // when
        String string = lotto.toString();

        // then
        assertThat(string).isEqualTo(
                list.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ", "[", "]"))
        );
    }

    @DisplayName("두 로또가 같은 로또인지 비교한다.")
    @Test
    void compareLotto() {

        List<Integer> list1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> list2 = List.of(7, 8, 9, 10, 11, 12);

        assertAll(
                () -> assertThat(
                        new Lotto(list1).equals(new Lotto(list1))
                ).isTrue(),

                () -> assertThat(
                        new Lotto(list1).equals(new Lotto(list2))
                ).isFalse(),

                () -> assertThat(
                        new Lotto(list1).hashCode() == new Lotto(list1).hashCode()
                ).isTrue(),

                () -> assertThat(
                        new Lotto(list1).hashCode() == new Lotto(list2).hashCode()
                ).isFalse()
        );
    }

    @DisplayName("로또의 등수를 알 수 있다.")
    @Test
    void getLottoRank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        int bonusNumber = 6;

        // when
        LottoRank lottoRank = lotto.findLottoRank(winningLotto, bonusNumber);

        // then
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }
}
