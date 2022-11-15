package lotto.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RandomNumberTest{

	@DisplayName("랜덤으로 생성되는 로또의 수가 6개인지 확인")
	@Test
	void createRandomNumberSize() {
		randomNumber randomNumber= new randomNumber();
		assertThat(randomNumber.lotto.size()).isEqualTo(6);

	}
	@DisplayName("랜덤으로 생성되는 로또의 수 범위가가 1-45인지 확인")
	@Test
	void createRandomNumberRange() {
		randomNumber randomNumber= new randomNumber();
		for (int i=0; randomNumber.lotto.size()>i;i++){
			assertThat(randomNumber.lotto.get(i)<45 &&
				randomNumber.lotto.get(i)>1).isTrue();
		}
	}
}
