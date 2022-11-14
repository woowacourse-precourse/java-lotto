package lotto.Domain;

import lotto.Domain.MainValue.Bonus;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BonusTest {
    SoftAssertions softAssertions = new SoftAssertions();
    @DisplayName("보너스 번호에 문자가 들어가면 에러가 발생한다")
    @Test
    void createBonusByChar() {
        softAssertions.assertThatThrownBy(() -> new Bonus("a1", List.of(1,2,3,4,5,6)))
                .hasMessageContaining("[ERROR]")
                .isInstanceOf(IllegalArgumentException.class);

        softAssertions.assertAll();
    }

    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니면 에러가 발생한다")
    @Test
    void createBonusOutOfRange() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        softAssertions.assertThatThrownBy(() -> new Bonus("46", List.of(1,2,3,4,5,6)))
                .hasMessageContaining("ERROR")
                .isInstanceOf(IllegalArgumentException.class);

        softAssertions.assertAll();
    }

    @DisplayName("보너스 번호가 로또 번호와 같으면 에러가 발생한다")
    @Test
    void createBonusOverlap() {
        softAssertions.assertThatThrownBy(() -> new Bonus("1", List.of(1,2,3,4,5,6)))
                .hasMessageContaining("ERROR")
                .isInstanceOf(IllegalArgumentException.class);

        softAssertions.assertAll();
    }


    // 아래에 추가 테스트 작성 가능
}
