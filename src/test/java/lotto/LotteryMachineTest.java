package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LotteryMachineTest {

  private static int LOTTO_TICKET = 4;
  private static final int MIN_NUM = 1;
  private static final int MAX_NUM = 45;


  @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
  @Test
  void createGenerateLottoByOverSize() {
    LotteryMachine generateLottoRepository = new LotteryMachine(LOTTO_TICKET);

    for (List<Integer> lotto : generateLottoRepository.lottoRepository){
      assertThat(lotto.size()).isEqualTo(6);
    }
  }

  @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
  @Test
  void createGenerateLottoByDuplicatedNumber() {
    LotteryMachine generateLottoRepository = new LotteryMachine(LOTTO_TICKET);

    for (List<Integer> lotto : generateLottoRepository.lottoRepository){
      assertThat(new HashSet<>(lotto).size()).isEqualTo(lotto.size());
    }
  }

  @DisplayName("로또 번호는 1부터 45 사이의 숫자를 벗어나면 예외가 발생한다.")
  @Test
  void createGenerateLotto1Between45() {
    LotteryMachine generateLottoRepository = new LotteryMachine(LOTTO_TICKET);

    for (List<Integer> lotto : generateLottoRepository.lottoRepository) {
      for (Integer num : lotto) {
        assertThat(num).isBetween(MIN_NUM, MAX_NUM);
      }
    }

  }
}