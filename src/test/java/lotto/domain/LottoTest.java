package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

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

    @DisplayName("getLottoPrinting 메서드는 로또의 값을 string으로 반환해줌")
    @ParameterizedTest
    @MethodSource("generateBasicLotto")
    void case1(Lotto lotto,String expected){
         assertThat(lotto.getLottoPrinting()).isEqualTo(expected);
    }

    @DisplayName("contains 메서드는 로또 안에 특정 숫자가 있는지 검사한다")
    @ParameterizedTest
    @MethodSource("generateBasicLotto")
    void case2(Lotto lotto){
        assertThat(lotto.contains(1)).isEqualTo(true);
        assertThat(lotto.contains(43)).isEqualTo(false);
    }

    @DisplayName("contains 메서드는 로또 안에 보너스 넘버가 중복으로 있는지 검사한다")
    @ParameterizedTest
    @MethodSource("generateBasicLotto")
    void case3(Lotto lotto){
        BonusNumber bonus1=new BonusNumber(1);
        BonusNumber bonus43=new BonusNumber(43);
        assertThat(lotto.contains(bonus1)).isEqualTo(true);
        assertThat(lotto.contains(bonus43)).isEqualTo(false);
    }

    @DisplayName("calculateScore 메서드는 로또를 받아서 점수를 계산한다 반환한다")
    @ParameterizedTest
    @MethodSource("generateBasicLotto")
    void case4(Lotto lotto){
        Lotto lotto1=new Lotto(List.of(1,13,14,15,16,17));
        assertThat(lotto.getScore(lotto)).isEqualTo(6);
        assertThat(lotto.getScore(lotto1)).isEqualTo(1);
    }

    private static Stream<Arguments> generateBasicLotto(){
        return Stream.of(
                Arguments.of(new Lotto(List.of(1,2,3,4,5,6)),"[1, 2, 3, 4, 5, 6]"),
                Arguments.of(new Lotto(List.of(1,11,22,33,44,45)),"[1, 11, 22, 33, 44, 45]")
        );
    }
    // 아래에 추가 테스트 작성 가능
}
