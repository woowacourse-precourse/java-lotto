package ExceptionCollections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CommonExceptionTest {
    @DisplayName("문자열이 포함되어 있는지 확인한다.")
    @Test
    void 문자열_포함_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> CommonException.hasCharacters("1a")
        );
    }

    @DisplayName("구매금액 단위를 확인한다.")
    @Test
    void 구매금액_단위_테스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> CommonException.validatePaymentUnit(10230)
        );
    }

    @DisplayName("최소 번호보다 작은 번호는 예외처리한다.")
    @Test
    void 최소_숫자_범위_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> CommonException.validateNumberRange(0)
        );
    }

    @DisplayName("최대 번호보다 큰 번호는 예외처리한다.")
    @Test
    void 최대_숫자_범위_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> CommonException.validateNumberRange(47)
        );
    }

    @DisplayName("당첨 번호 개수가 6개이다.")
    @Test
    void 당첨_번호_개수_테스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> CommonException.validateNumberLength(List.of(1, 2, 3, 4), 6)
        );
    }

    @DisplayName("중복되는 숫자는 예외 처리한다.")
    @Test
    void 당첨_번호_중복_테스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> CommonException.hasSameNumber(List.of(1, 2, 3, 4, 5, 6), 6)
        );
    }
}
