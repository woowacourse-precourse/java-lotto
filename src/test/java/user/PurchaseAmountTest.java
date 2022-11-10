package user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PurchaseAmountTest {

    @DisplayName("올바른 로또 구입 금액이 입력되어 PurchaseAmount 객체 생성에 성공한다")
    @Test
    void 올바른_로또_구입_금액이_입력되어_객체생성에_성공한다() {
        // given

        // when & then
        assertAll(
                () -> assertThat(new PurchaseAmount("1000").getPurchaseAmount())
                        .isEqualTo(1000),
                () -> assertThat(new PurchaseAmount("10000").getPurchaseAmount())
                        .isEqualTo(10000),
                () -> assertThat(new PurchaseAmount("2100000000").getPurchaseAmount())
                        .isEqualTo(2_100_000_000)
        );
    }

    @DisplayName("잘못된 로또 구입 금액이 입력되어 예외가 던져진다")
    @Test
    void 잘못된_로또_구입_금액이_입력되어_객체생성에_실패한다() {
        // given

        // when & then
        IllegalArgumentException includeNotNumberEx = assertThrows(
                IllegalArgumentException.class,
                () -> new PurchaseAmount("1000j")
        );

        IllegalArgumentException outOfRangeEx = assertThrows(
                IllegalArgumentException.class,
                () -> new PurchaseAmount("0")
        );

        IllegalArgumentException notDivideByThousandUnitEx = assertThrows(
                IllegalArgumentException.class,
                () -> new PurchaseAmount("999")
        );

        assertAll(
                () -> assertThat(includeNotNumberEx.getMessage()).startsWith("[ERROR]"),
                () -> assertThat(outOfRangeEx.getMessage()).startsWith("[ERROR]"),
                () -> assertThat(notDivideByThousandUnitEx.getMessage()).startsWith("[ERROR]")
        );
    }
}