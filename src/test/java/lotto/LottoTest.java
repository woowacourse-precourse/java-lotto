package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Game;
import domain.Grade;
import org.assertj.core.api.AbstractComparableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


import static Service.LottoService.lottoSpawner;
import static Service.gradeService.setGrades;
import static domain.Game.getLottoCount;
import static domain.Grade.getGrade;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName(",를 기준으로 문자열을 나눈다.")
    @Test
    void splitTest() {
        String str = "1,2,3";
        String[] t_str = str.split(",");
        assertThat(t_str).containsExactly("1", "2", "3");
    }

    @DisplayName("중복값이 있는지 테스트")
    @Test
    void overLapTest() {
        List<Integer> test = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        assertThat(test.size()).isEqualTo(test.stream().distinct().count());
    }

    @DisplayName("로또 번호맞은 갯수 판별")
    @Test
    void hitCountTest() {
        Lotto lotto = new Lotto(List.of(11, 12, 13, 42, 37, 10));

        assertThat(lotto.get_hitCount(List.of(1, 31, 42, 37, 11, 12))).isEqualTo(4);
    }

    @DisplayName("로또의 당첨등수가 출력되는지 테스트")
    @Test
    void getGradeTest() {

        assertThat(getGrade(3, false)).isEqualTo(Grade.Lottogrades.fifth);
        AbstractComparableAssert<?, Grade.Lottogrades> equalTo = assertThat(getGrade(5, true)).isEqualTo(Grade.Lottogrades.second);


    }

    @Test
    void controllerPrintMessageTest() {
        lottoSpawner(8);

        List<Integer> winning_numbers = List.of(1, 31, 25, 36, 42, 11);
        setGrades();
        //assertThat().isEqualTo();
    }

    @DisplayName("구입한 로또의 갯수를 출력하는 기능 추가")
    @Test
    void getLottoCountTest() {
        Game.paymentAmount = 8000;
        // assertThatThrownBy(() ->).isInstanceOf(IllegalArgumentException.class);
        assertThat(getLottoCount()).isEqualTo(8);
    }

    // 아래에 추가 테스트 작성 가능
}
