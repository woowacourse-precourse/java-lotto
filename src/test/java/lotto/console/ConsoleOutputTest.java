package lotto.console;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsoleOutputTest {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  private final ConsoleOutput output = new ConsoleOutput();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  void 로또번호가_정렬돼서_출력된다() {
    List<Lotto> givenLotto = List.of(
        new Lotto(new ArrayList<>(Arrays.asList(2, 3, 5, 1, 4, 6))),
        new Lotto(new ArrayList<>(Arrays.asList(21, 31, 32, 15, 41, 5)))
    );
    StringBuilder sb = new StringBuilder();
    String expectedString = sb
        .append("[1, 2, 3, 4, 5, 6]").append("\n")
        .append("[5, 15, 21, 31, 32, 41]").append("\n").toString();
    output.printLotto(givenLotto);

    assertThat(outputStreamCaptor.toString()).contains(expectedString);
  }


  @Test
  void  당첨된결과와_수익률이_출력된다(){
    List<LottoPrize> lottoPrizes = List.of(LottoPrize.FIFTH);
    double givenRate = 62.5;

    output.printResult(lottoPrizes, givenRate);

    assertThat(outputStreamCaptor.toString()).contains("3개 일치 (5,000원) - 1개");
    assertThat(outputStreamCaptor.toString()).contains("총 수익률은 62.5%입니다.");
  }
  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
  }

}