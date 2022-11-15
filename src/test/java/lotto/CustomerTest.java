package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomerTest {
    @DisplayName("Customer 생성시 올바른 값을 입력하면 정상 생성")
    @Test
    void createCustomerGood(){
        Customer customer = new Customer("2000");
        assertThat(customer.getMoney()).isEqualTo(2000);
    }

    @DisplayName("Customer 생성시 잘못 된 값을 입력하면 예외 발생")
    @Test
    void createCustomerBad(){
        //정수가 아닐때
        assertThatThrownBy(() -> new Customer("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
        //0이거나 음수 일때
        assertThatThrownBy(() -> new Customer("-1"))
                .isInstanceOf(IllegalArgumentException.class);
        //제한 금액 초과 일때
        assertThatThrownBy(() -> new Customer("1111111111111111111111111111111111"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Customer("2000000000"))
                .isInstanceOf(IllegalArgumentException.class);
        //단위 금액으로 나눠 떨어지지 않을때
        assertThatThrownBy(() -> new Customer("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }



}
