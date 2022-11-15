package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class JudgmentTest {
    private Judgment judgment;
    
    @BeforeEach
    void setUp() {
        judgment = new Judgment();
    }
    
    @DisplayName("음수를 입력받으면 예외가 발생한다.")
    @Test
    void countLottos_테스트1() {
        assertThatThrownBy(() -> judgment.countLottos(-1))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("1000으로 나눠떨어지지 않으면 예외가 발생한다.")
    @Test
    void countLottos_테스트2() {
        assertThatThrownBy(() -> judgment.countLottos(1234))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName(",의 개수가 5개가 아니면 예외가 발생한다.")
    @Test
    void check5Commas_테스트() {
        assertThatThrownBy(() -> judgment.check5Commas("1,2,3,4,5"))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("정해진 범위와 다르면 예외가 발생한다.")
    @Test
    void checkRange_테스트() {
        assertThatThrownBy(() -> judgment.checkRange(50, 1, 45))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("정해진 길이와 다르면 예외가 발생한다.")
    @Test
    void checkSize_테스트() {
        assertThatThrownBy(() -> judgment.checkSize(List.of(1,2), 3))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("리스트 원소중 하나라도 정해진 범위와 다르면 예외가 발생한다.")
    @Test
    void checkNumbersRange_테스트() {
        assertThatThrownBy(() -> judgment.checkNumbersRange(List.of(1, 2, 3), 1, 2))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("리스트 원소에 중복이 있으면 예외가 발생한다.")
    @Test
    void duplicateCheck_테스트() {
        assertThatThrownBy(() -> judgment.duplicateCheck(List.of(1, 2, 2)))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("숫자로 변환할 수 없는 문자가 있으면 예외가 발생한다.")
    @Test
    void changeToInteger_테스트() {
        assertThatThrownBy(() -> judgment.changeToInteger(List.of("a", "2", "2")))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("당첨 번호와 구매 번호가 같으면 6이다.")
    @Test
    void correctCount_테스트() {
        int count = judgment.correctCount(List.of(1,2,3,4,5,6), List.of(6,5,4,3,2,1));
        assertThat(count).isEqualTo(6);
    }
    
    @DisplayName("보너스 번호가 포함되어 있으면 true다.")
    @Test
    void hasBonus_테스트() {
        boolean hasBonus = judgment.hasBonus(5, List.of(6,5,4,3,2,1));
        assertThat(hasBonus).isEqualTo(true);
    }
}
