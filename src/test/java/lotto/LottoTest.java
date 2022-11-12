package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Amount;
import domain.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


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


    @Test
    void overLapTest(){
        List<Integer> test = Randoms.pickUniqueNumbersInRange(1,45,6);
        assertThat(test.size()).isEqualTo(test.stream().distinct().count());
    }
    @Test
    void hitCountTest(){
        Lotto lotto=new Lotto(List.of(11,12,13,42,37,10));

        assertThat(lotto.get_hitCount(List.of(1,31,42,37,11,12))).isEqualTo(4);
    }

    @Test
    void getGradeTest(){

        assertThat(Amount.getGrade(3,false)).isEqualTo(Amount.grade.fifth);
        assertThat(Amount.getGrade(5,true)).isEqualTo(Amount.grade.second);

    }

    // 아래에 추가 테스트 작성 가능
}
