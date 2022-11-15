package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidCheckTest {

    @Test
    void validateLottoDuplicate() {
        assertThatThrownBy(() -> ValidCheck.validateLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateLottoOutOfRange() {
        assertThatThrownBy(() -> ValidCheck.validateLotto(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateLottoNotSixDigit() {
        assertThatThrownBy(() -> ValidCheck.validateLotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void formatCheckLottoNotComma() {
        assertThatThrownBy(() -> ValidCheck.formatCheckLotto("1 2 3 4 5 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void formatCheckLength() {
        assertThatThrownBy(() -> ValidCheck.formatCheckLotto("1,6,7,8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void formatCheckIncludeNoneDigit() {
        assertThatThrownBy(() -> ValidCheck.formatCheckLotto("1,2,3,4,5,가"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void formatCheckBonus() {
        assertThatThrownBy(() -> ValidCheck.formatCheckBonus("가"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void formatCheckBonusOutOfRange() {
        assertThatThrownBy(() -> ValidCheck.formatCheckBonus("655"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void formatCheckPriceWithComma() {
        assertThatThrownBy(() -> ValidCheck.formatCheckPrice("14,000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void formatCheckPrice() {
        assertThatThrownBy(() -> ValidCheck.formatCheckPrice("14001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}