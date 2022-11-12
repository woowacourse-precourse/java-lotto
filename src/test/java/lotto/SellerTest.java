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

        assertThat(seller.issueLottos(new Money(14000))).hasSize(14);
    }

    @DisplayName("잔돈이 있으면 예외를 발생시킨다")
    @Test
    void changes_throw_IllegalArgumentException() {
        Seller seller = new Seller();

        assertThatIllegalArgumentException().isThrownBy(() -> seller.issueLottos(new Money(14123)));
    }
}
