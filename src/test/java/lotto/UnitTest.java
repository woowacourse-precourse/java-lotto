package lotto;

import jdk.jshell.execution.Util;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class UnitTest {

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


}
