package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LotteryMachine {

  private static final int MIN_NUM = 1;
  private static final int MAX_NUM = 45;
  private static final int LOTTO_LENGTH = 6;
  public int lottoCount;
  public List<List<Integer>> lottoRepository;

  public LotteryMachine(int count) {
    lottoRepository = new ArrayList<>();
    lottoCount = count;
    this.GenerateLotto(lottoCount);
  }


  public void GenerateLotto(int count) {
    for (int i = 0; i < count; i++) {
      lottoRepository.add(Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_LENGTH));
    }

  }
}