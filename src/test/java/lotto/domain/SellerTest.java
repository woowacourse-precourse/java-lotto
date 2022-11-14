package lotto.domain;

import lotto.utils.StringToIntConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SellerTest {
    @Test
    @DisplayName("seller 인스턴스 반환 성공")
    void getSellerInstance() {
        Seller seller = new Seller(new StringToIntConverter());
        assertThat(seller).isNotNull();
    }

    @Test
    @DisplayName("사용자 금액 입력 성공_로또 발행")
    void sellLotto_Success() {
        Seller seller = new Seller(new StringToIntConverter());
        String money = "3000";
        IssuedLotto issuedLotto = seller.sellLotto(money);

        assertThat(issuedLotto.getTotalCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("사용자 금액 1000원 단위 미입력 실패")
    void sellLotto_Exception_Not_Divided_1000() {
        Seller seller = new Seller(new StringToIntConverter());
        String money = "3200";

        assertThatThrownBy(() -> seller.sellLotto(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자 금액 문자 포함 입력 실패")
    void sellLotto_Exception_Contains_String() {
        Seller seller = new Seller(new StringToIntConverter());
        String money = "30001";

        assertThatThrownBy(() -> seller.sellLotto(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}