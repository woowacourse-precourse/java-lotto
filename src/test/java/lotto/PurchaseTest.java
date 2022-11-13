package lotto;

import lotto.domain.Purchase;
import lotto.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PurchaseTest {
//    @DisplayName("정상 입력 테스트")
//    @Test
//    void normalInputTest() {
//        String input1 = "1000";
//        assertThat(new Purchase(input1).getPurchaseAmount()).isEqualTo(1000);
//
//        String input2 = "80000";
//        assertThat(new Purchase(input2).getPurchaseAmount()).isEqualTo(80000);
//    }
//
//    @DisplayName("입력금액에 문자 포함시 예외 발생")
//    @Test
//    void includeCharacter() {
//        String input1 = "ds1000";
//        assertThatThrownBy(()->Purchase.validatePurchaseInput(input1)).isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("입력금액이 1000원 단위가 아닐 경우 예외 발생")
//    @Test
//    void invalidUnit() {
//        Winning winning = new Winning();
//
//        String input1 = "1234";
//        assertThatThrownBy(()->new Purchase().initPurchase(input1)).isInstanceOf(IllegalArgumentException.class);
//        assertThatThrownBy(()->new Purchase().initPurchase(input1)).isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 입력해 주세요.");
//
//        String input2 = "12432422211534";
//        assertThatThrownBy(()->new Purchase().initPurchase(input2)).isInstanceOf(IllegalArgumentException.class);
//        assertThatThrownBy(()->new Purchase().initPurchase(input2)).isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 입력해 주세요.");
//
//        String input3 = "0";
//        assertThatThrownBy(()->new Purchase().initPurchase(input3)).isInstanceOf(IllegalArgumentException.class);
//        assertThatThrownBy(()->new Purchase().initPurchase(input3)).isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 입력해 주세요.");
//
//        String input4 = "999";
//        assertThatThrownBy(()->new Purchase().initPurchase(input4)).isInstanceOf(IllegalArgumentException.class);
//        assertThatThrownBy(()->new Purchase().initPurchase(input4)).isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 입력해 주세요.");
//    }
//
//    @DisplayName("입력안할 경우 예외 발생")
//    @Test
//    void blankInput() {
//        String input = "";
//        assertThatThrownBy(()->new Purchase().initPurchase(input)).isInstanceOf(IllegalArgumentException.class);
//        assertThatThrownBy(()->new Purchase().initPurchase(input)).isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("[ERROR] 구매금액에 문자를 입력할 수 없습니다.");
//    }
//
//    @DisplayName("로또 생성기 테스트")
//    @Test
//    void lottoCreatorTest() {
//        Purchase purchase = new Purchase();
//        purchase.initPurchase("1000");
//        purchase.lottoCreator();
//    }
}
