package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

public class LottoTest {
    private static final String ERROR_PREFIX_MASSAGE = "[ERROR] ";
    private static final String ERROR_SIZE_MASSAGE = "로또 번호는 6개입니다.";
    private static final String ERROR_RANGE_MASSAGE = "로또 번호는 1부터 45까지입니다.";
    private static final String ERROR_DUPLICATE_MASSAGE = "로또 번호에 중복된 숫자는 없습니다.";
    private Lotto lotto;

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 로또_번호_개수_테스트() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 중복된_로또_번호_테스트() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 45이하의 숫자만 있어야 한다.")
    @Test
    void 로또_번호_최대_범위_테스트() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 1이상의 숫자만 있어야 한다.")
    @Test
    void 로또_번호_최소_범위_테스트() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 오름차순으로 정렬되어야 한다.")
    @Test
    void 로또_번호_정렬_테스트() {
        lotto = new Lotto(new ArrayList<>(List.of(6, 2, 3, 4, 1, 5)));
        assertEquals(List.of(1, 2, 3, 4, 5, 6), lotto.getLottoNumbers());
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 로또_번호_개수_에러_메세지_테스트() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
            new Lotto(List.of(1, 2, 3, 4, 5, 6, 7))
        );
        assertEquals(ERROR_PREFIX_MASSAGE + ERROR_SIZE_MASSAGE
            , exception.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 중복된_로또_번호_에러_메세지_테스트() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
            new Lotto(List.of(1, 2, 3, 4, 5, 5))
        );
        assertEquals(ERROR_PREFIX_MASSAGE + ERROR_DUPLICATE_MASSAGE
            , exception.getMessage());
    }

    @DisplayName("로또 번호는 45이하의 숫자만 있어야 한다.")
    @Test
    void 로또_번호_최대_범위_에러_메세지_테스트() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
            new Lotto(List.of(1, 2, 3, 4, 5, 46))
        );
        assertEquals(ERROR_PREFIX_MASSAGE + ERROR_RANGE_MASSAGE
            , exception.getMessage());
    }

    @DisplayName("로또 번호는 1이상의 숫자만 있어야 한다.")
    @Test
    void 로또_번호_최소_범위_에러_메세지_테스트() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
            new Lotto(List.of(1, 2, 3, 4, 5, 0))
        );
        assertEquals(ERROR_PREFIX_MASSAGE + ERROR_RANGE_MASSAGE
            , exception.getMessage());
    }
}
