package lotto.view;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

	@Test
	@DisplayName("문자열을 입력받아 ,를 기준으로 나누어 저장")
	void getLottoNumbersTest() {
		String[] strings1 = new String[6];
		String[] strings2 = new String[6];
		for (int i = 0; i < strings2.length; i++) {
			strings2[i] = String.valueOf(i);
		}
		strings1 = "0,1,2,3,4,5".split(",");
		Assertions.assertThat(strings1).isEqualTo(strings2);
	}

	@Test
	@DisplayName("문자열 배열을 정수 리스트로 변환")
	void ConvertIntoIntegerListTest() {
		String[] strings = new String[6];
		List<Integer> list1 = new ArrayList<>();
		for (int i = 0; i < strings.length; i++) {
			strings[i] = String.valueOf(i);
			list1.add(i);
		}
		Assertions.assertThat(InputView.convertIntoIntegerList(strings)).isEqualTo(list1);
	}

}
