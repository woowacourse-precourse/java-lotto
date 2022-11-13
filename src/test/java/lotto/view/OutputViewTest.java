package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.service.StatisticsDto;
import lotto.util.ViewConst;

class OutputViewTest {

	private OutputView outputView = new OutputView();
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@Test
	void printUserLottoTest() {
		//given
		Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 45));
		List<Lotto> lottos = new ArrayList<>();
		lottos.add(lotto1);
		lottos.add(lotto2);

		//when
		outputView.printUserLotto(lottos);

		//then
		assertThat(outContent.toString()).contains(lotto1.toString(), lotto2.toString());
	}

	@Test
	void printLottoCountTest() {
		//given
		String lottoCount = "1";
		String result = lottoCount + ViewConst.LOTTO_COUNT_OUTPUT;

		//when
		outputView.printLottoCount(Integer.valueOf(lottoCount));

		//then
		assertThat(outContent.toString()).contains(result);
	}

	@Test
	void printUserStatisticsTest() {
		//given
		Double yield = 100d;
		StatisticsDto statisticsDto = new StatisticsDto(List.of("empty"), yield);

		//when
		outputView.printUserStatistics(statisticsDto);

		//then
		assertThat(outContent.toString()).contains(ViewConst.STATISTICS_OUTPUT,
			"총 수익률은 " + statisticsDto.getYield() + "%입니다.");
	}

	@Test
	void printErrorTest() {
		//given
		String errorMessage = "[ERROR]";

		//when
		outputView.printError(errorMessage);

		//then
		assertThat(outContent.toString()).contains(errorMessage);
	}
}
