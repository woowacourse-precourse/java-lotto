package lotto.ExceptionChecker;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberCheckerTest {

    @DisplayName("로또 번호와 보너스 번호중 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new BonusNumberChecker(6,List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("보너스 번호 입력값이 1~45 사이가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberOutOfRange() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new BonusNumberChecker(46,List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(NoSuchElementException.class);
    }

}