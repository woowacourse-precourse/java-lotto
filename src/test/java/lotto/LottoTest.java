package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    //region 예외 사항 테스트
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 되지 않으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 번호가 1보다 작을 경우 예외가 발생한다.")
    @Test
    void createLottoByUnder1() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, -1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45보다 클 경우 예외가 발생한다.")
    @Test
    void createLottoByOver45() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    //endregion

    //region 함수 테스트
    @DisplayName("보너스 번호 체크할 때 로또 번호에 보너스 번호가 포함되는 경우")
    @Test
    void existBonusInLotto() {
        boolean existBonus = Lotto.CheckBonus(new Lotto(List.of(1,2,3,4,5,6)), 1);
        assertThat(existBonus).isEqualTo(true);
    }

    @DisplayName("보너스 번호 체크할 때 로또 번호에 보너스 번호가 포함되지 않는 경우")
    @Test
    void nonExistBonusInLotto() {
        boolean existBonus = Lotto.CheckBonus(new Lotto(List.of(1,2,3,4,5,6)), 7);
        assertThat(existBonus).isEqualTo(false);
    }

    @DisplayName("로또 번호와 당첨 번호의 수가 같은 것이 정상작동하는지 확인")
    @Test
    void confirmLottoSameNumberInWinning() {
        int same;
        //0개
        same = Lotto.CountSameNumber(new Lotto(List.of(1,2,3,4,5,6)),new Lotto(List.of(7,8,9,10,11,12)));
        assertThat(same).isEqualTo(0);

        //1개
        same = Lotto.CountSameNumber(new Lotto(List.of(1,2,3,4,5,6)),new Lotto(List.of(1,8,9,10,11,12)));
        assertThat(same).isEqualTo(1);

        //2개
        same = Lotto.CountSameNumber(new Lotto(List.of(1,2,3,4,5,6)),new Lotto(List.of(1,2,9,10,11,12)));
        assertThat(same).isEqualTo(2);

        //3개
        same = Lotto.CountSameNumber(new Lotto(List.of(1,2,3,4,5,6)),new Lotto(List.of(1,2,3,10,11,12)));
        assertThat(same).isEqualTo(3);

        //4개
        same = Lotto.CountSameNumber(new Lotto(List.of(1,2,3,4,5,6)),new Lotto(List.of(1,2,3,4,11,12)));
        assertThat(same).isEqualTo(4);

        //5개
        same = Lotto.CountSameNumber(new Lotto(List.of(1,2,3,4,5,6)),new Lotto(List.of(1,2,3,4,5,12)));
        assertThat(same).isEqualTo(5);

        //6개
        same = Lotto.CountSameNumber(new Lotto(List.of(1,2,3,4,5,6)),new Lotto(List.of(1,2,3,4,5,6)));
        assertThat(same).isEqualTo(6);
    }

    //endregion
}
