package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

  private final List<Integer> winningNumbersList = List.of(1, 2, 3, 4, 5, 6);
  private final Integer bonusNumber = 7;
  private final WinningNumber winningNumber = new WinningNumber(winningNumbersList, bonusNumber);

  @Test
  void 모두맞춘번호가있을때_결과에1등이_포함된다() {
    Lotto willFirstLotto = new Lotto(winningNumbersList);
    List<Lotto> lottos = List.of(willFirstLotto);

    List<LottoPrize> result = winningNumber.draw(lottos);

    assertThat(result).contains(LottoPrize.FIRST);
  }

  @Test
  void 로또개수에맞게_결과의_갯수도_리턴된다() {
    List<Lotto> lottos = List.of(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
        new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
        new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
    int expectedSize = lottos.size();

    List<LottoPrize> result = winningNumber.draw(lottos);

    assertThat(result.size()).isEqualTo(expectedSize);
  }
}