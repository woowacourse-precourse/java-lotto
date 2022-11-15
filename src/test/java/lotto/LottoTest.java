package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
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

    @DisplayName("보너스 숫자가 1~45범위밖이라면 에러메시지 프린트.")
    @Test
    void bonusNumberNotInRange() {
        assertSimpleTest(() -> {
            try {
                run("1000", "1,2,3,4,5,6", "52");
            } catch (IllegalArgumentException e) {
                assertThat(output().contains(ERROR_MESSAGE));
            }
        });
    }

    @DisplayName("플레이어가 입력한 6개의 숫자가 1~45범위밖이라면 에러메시지 프린트.")
    @Test
    void printErrorMessageIfNotInRange() {
        assertSimpleTest(() -> {
            try {
                run("8000", "1,2,3,4,5,66", "30");
            } catch (IllegalArgumentException e) {
                assertThat(output().contains(ERROR_MESSAGE));
            }
        });
    }
    @Override
    protected void runMain() {Lotto.main(new String[]{});}
}
