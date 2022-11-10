package lotto;

import jdk.jshell.execution.Util;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UnitTest { // TODO : 클래스 이름 변경

	@Test
	void 랜덤_숫자_추출_테스트(){
		int randomNum = Util.getRandomNum(1, 45);
		assertThat(randomNum)
				.isGreaterThanOrEqualTo(1)
				.isLessThanOrEqualTo(45);
	}

	@Test
	void 로또_발행_테스트(){
		List<Integer> randomNums = Util.getDistinctRandomNums(6);
		List<Integer> filtered = randomNums.stream()
				.distinct()
				.collect(Collectors.toList());
		assertThat(filtered.size()).isEqualTo(6);
	}

	@Test
	void 당첨_번호_입력_테스트_정상_케이스(){
		assertThatThrownBy(() -> new LottoNumsValidator("1,2,3,4,5,6"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 당첨_번호_입력_테스트_예외_케이스1(){
		assertThatThrownBy(() -> new LottoNumsValidator("1 2 3 4 5 6"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 당첨_번호_입력_테스트_예외_케이스2(){
		assertThatThrownBy(() -> new LottoNumsValidator("what the hell"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 당첨_번호_입력_테스트_예외_케이스3(){
		assertThatThrownBy(() -> new LottoNumsValidator(""))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
