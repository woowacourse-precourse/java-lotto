package model;

import model.Lotto;

import org.assertj.core.api.Assertions;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[Lotto] 로또 번호가 1~45 이상만을 생성하는지 검사한다 1000번을 검사해 정확도 100%를 테스트한다.")
    void generateLottoInRange() {
        //given
        int testCount=1000;
        int errorCount=0;
        //when
        List<Integer> generateNumbers = Lotto.generateLotto();
        for (int test = 0; test < testCount; test++) {
            try{
                new Lotto(generateNumbers);
            }catch (IllegalArgumentException exception){
                errorCount++;
            }
        }
        int accurate = Math.abs(testCount - errorCount) / testCount*100;
        //then
        Assertions.assertThat(accurate).isEqualTo(100);
    }

}
