package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.dto.PurchaseAmountDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("[정상] 올바른 구매 금액을 전달할시에 사용자 클래스 생성된다.")
    @Test
    void createUser() {
        PurchaseAmountDto purchaseAmountDto = PurchaseAmountDto.of(10_000);
        User user = User.of(purchaseAmountDto);
        for (Lotto lotto : user.getLottos()) {
            System.out.println(lotto);
        }
        assertThat(user.getLottos().size())
                .isEqualTo(10);
    }
}
