package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;

public class LottoProgramTest extends NsTest {
	List<Lotto> lottoList;

	@BeforeEach
	void setUp() {
		lottoList = LottoProgram.getLottoList();
	}

	@Test
	void 똑같은_수의_로또_존재_여부_테스트() {
		boolean isSameLottoNumberExist = lottoList.stream()
			.distinct()
			.count() != lottoList.size();

		assertThat(isSameLottoNumberExist).isFalse();

	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
