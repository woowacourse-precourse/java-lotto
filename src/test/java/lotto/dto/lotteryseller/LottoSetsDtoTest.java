package lotto.dto.lotteryseller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoSetsDtoTest {
	@DisplayName("로또 세트가 제대로 생성되었는지 확인한다.") @Test void equalToInputTest() {
		List<List<Integer>> lotto =
			Arrays.asList(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12),
				List.of(12, 43, 32, 27, 10, 8));
		int size = lotto.size();
		LottoSetsDto lottoSetsDto = new LottoSetsDto(lotto, size);

		Assertions.assertThat(lottoSetsDto.getLottoSets()).isEqualTo(
			Arrays.asList(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12),
				List.of(12, 43, 32, 27, 10, 8)));
		Assertions.assertThat(lottoSetsDto.getLottoSetsSize()).isEqualTo(3);
	}
}
