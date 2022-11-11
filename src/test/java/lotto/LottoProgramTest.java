package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;

public class LottoProgramTest extends NsTest {
	List<Lotto> lottoList;
	LottoProgram lottoProgram;

	@BeforeEach
	void setUp() {
		lottoProgram = new LottoProgram();
		lottoList = LottoProgram.getLottoList();
	}

	@Test
	void createLotto_메서드로_다른_수를_가진_로또_생성() {
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
