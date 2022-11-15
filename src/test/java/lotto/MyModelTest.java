package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyModelTest {
	@DisplayName("모델에 문자열이 정상적으로 저장되어야 한다.")
	@Test
	void modelTest1() {
		MyModel model = new MyModel();
		String attribute1 = "abc";
		model.addAttribute("attribute1", attribute1);

		String result = (String)model.getAttribute("attribute1");
		assertThat(attribute1).isEqualTo(result);
	}

	@DisplayName("모델에 여러 자료형이 정상적으로 저장되어야 한다.")
	@Test
	void modelTest2() {
		MyModel model = new MyModel();
		String attribute1 = "bcd";
		List<Integer> attribute2 = List.of(1, 2, 3, 4);
		model.addAttribute("attribute1", attribute1);
		model.addAttribute("attribute2", attribute2);

		String result1 = (String)model.getAttribute("attribute1");
		List<Integer> result2 = (List<Integer>)model.getAttribute("attribute2");
		assertThat(result1).isEqualTo(attribute1);
		assertThat(result2).isEqualTo(attribute2);
	}
}
