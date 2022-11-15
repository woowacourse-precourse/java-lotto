package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.User;

public class UserTest {
	User user;
	
	@BeforeEach
	void setup() {
		user = new User();
	}
	
	@DisplayName("로또 구매 금액이 정상적인 금액일 경우")
    @Test
    void createPurchaseCount() {
		assertThat(user.getPurchaseCount("1000")).isEqualTo(1);
		
		assertThat(user.getPurchaseCount("5000")).isEqualTo(5);
		
		assertThat(user.getPurchaseCount("10000")).isEqualTo(10);
		
		assertThat(user.getPurchaseCount("13000")).isEqualTo(13);
    }
	
	@DisplayName("로또 구매 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createPurchaseCountByNotNumber() {
		assertThatThrownBy(() -> user.getPurchaseCount("천원"))
        .isInstanceOf(IllegalArgumentException.class);
    }
	
	@DisplayName("로또 구매 금액이 음수이면 예외가 발생한다.")
    @Test
    void createPurchaseCountByMinusCost() {
		assertThatThrownBy(() -> user.getPurchaseCount("-1000"))
        .isInstanceOf(IllegalArgumentException.class);
    }
	
	@DisplayName("로또 구매 금액이 음수이면 예외가 발생한다.")
    @Test
    void createPurchaseCountByZeroCost() {
		assertThatThrownBy(() -> user.getPurchaseCount("0"))
        .isInstanceOf(IllegalArgumentException.class);
    }
	
	@DisplayName("로또 구매 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createPurchaseCountByInvaildCost() {
		assertThatThrownBy(() -> user.getPurchaseCount("1500"))
        .isInstanceOf(IllegalArgumentException.class);
    }
	
	@DisplayName("로또 구매 금액이 int 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createPurchaseCountByExceedInt() {
		assertThatThrownBy(() -> user.getPurchaseCount("10000000000"))
        .isInstanceOf(IllegalArgumentException.class);
    }
}
