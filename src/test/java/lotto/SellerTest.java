package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SellerTest {

    @DisplayName("금액만큼 로또를 판매한다")
    @Test
    void issue_lottos_based_on_money() {
        Seller seller = new Seller();

        assertThat(seller.issueLottos(14000)).hasSize(14);
    }

    @DisplayName("금액이 단위로 나눠떨어지지 않으면 예외를 발생시킨다")
    @Test
    void money_dividing_with_remainder_throws_IllegalArgumentException() {
        Seller seller = new Seller();

        assertThatIllegalArgumentException().isThrownBy(() -> seller.issueLottos(14123));
    }

    @DisplayName("금액이 음수면 예외를 발생시킨다")
    @Test
    void negative_money_throws_IllegalArgumentException() {
        Seller seller = new Seller();

        assertThatIllegalArgumentException().isThrownBy(() -> seller.issueLottos(-1000));
    }
}
