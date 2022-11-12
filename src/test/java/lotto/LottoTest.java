package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("보너스 번호가 로또 번호와 중복이 있으면 예외가 발생한다.")
    @Test
    void createLottoAndBonusWithDuplicatedNumber() {
        final NumberGenerator numberGenerator = new NumberGenerator();
        numberGenerator.bonusNumber = 5;
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6))
                .exceptionBonusNumberByDuplicatedLotto(numberGenerator.bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 갯수가 6개 미만일 경우 예외가 발생한다.")
    @Test
    void createLottoLessThanSix() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 1000원 단위로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void createPurchasePriceNotDividedThousands() {
        final int purchasePrice = 1500;
        assertThatThrownBy(() -> new NumberGenerator()
                .exceptionDividedIntoThousands(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 ~ 45사이의 값이 아닐 경우 예외가 발생합니다.")
    @Test
    void createOutOfRangeOfLottoNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1 ~ 45사이의 값이 아닐 경우 예외가 발생합니다.")
    @Test
    void createOutOfRangeOfBonusNumber() {
        final int bonusNumber = 0;

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6))
                .exceptionBonusNumberOutOfRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("번호를 입력하지 않았을 경우 예외가 발생합니다.")
    @Test
    void enteredNoValue() {
        assertThatThrownBy(() -> new NumberGenerator()
                .addComputerNumber(new ArrayList<>(Arrays.asList(new String[]{null}))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
/**
 * - [o] 구매금액 입력 기능
 *
 * - [o] 구매금액 입력 만큼 로또 발행 수량 계산 기능
 *
 * - [o] 수량만큼 로또 발행하여 출력 기능
 *   - 로또 번호는 오름차순으로 정렬
 * - [o] 당첨 번호 및 보너스 번호 입력 기능
 *
 * - [o] 당첨 번호 데이터 타입(String -> List<Integer>) 변환 기능
 *
 * - [o] 당첨 통계 계산 기능
 *   - 3개 일치
 *   - 4개 일치
 *   - 5개 일치
 *     - 보너스 볼 일치 여부
 *   - 6개 일치
 *
 * - [o] 총 수익률 계산 기능
 *   - Enum 클래스로 구현
 */