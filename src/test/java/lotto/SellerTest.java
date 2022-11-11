package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SellerTest {

    @DisplayName("금액만큼 로또를 판매한다")
    @Test
    void issue_lottos_based_on_money() {
        Seller seller = new Seller();

        assertThat(seller.issueLottos(14000)).hasSize(14);
    }
}
