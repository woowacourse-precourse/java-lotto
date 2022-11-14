package lotto.tool;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class LottoTool {

  public static Lotto makeLotto() {
    List<Integer> numberList = Randoms.pickUniqueNumbersInRange(LottoChecker.MIN_LOTTO_NUMBER,
        LottoChecker.MAX_LOTTO_NUMBER, LottoChecker.LENGTH_LIMIT);
    List<Integer> sortedList = numberList.stream().sorted().collect(Collectors.toList());
    return new Lotto(sortedList);
  }

  //변환
  public static List<Integer> convertToIntegerList(String[] inputList) {
    List<Integer> numberList = new ArrayList<>();
    for (int i = 0; i < LottoChecker.LENGTH_LIMIT; i++) {
      numberList.add(Integer.parseInt(inputList[i]));
    }
    return numberList;
  }

  public static HashMap<Rank, Integer> calcResult(List<Lotto> lottoList, Lotto winnerLotto,
      int bonnusNumber) {
    HashMap<Rank, Integer> hashMap = initResult();
    for (Lotto l : lottoList) {
      Rank rank = rankLotto(l, winnerLotto, bonnusNumber);
      if (!rank.equals(Rank.LOSE)) {
        hashMap.merge(rank, 1, Integer::sum);
      }
    }
    return hashMap;
  }

  //초기 result
  private static HashMap<Rank, Integer> initResult() {
    HashMap<Rank, Integer> result = new HashMap<>();
    for (Rank r : Rank.values()) {
      if (r.equals(Rank.LOSE)) {
        continue;
      }
      result.put(r, 0);
    }
    return result;
  }

  //로또번호의 순위(Prize)를 매기는 메서드
  private static Rank rankLotto(Lotto lotto, Lotto winnerLotto, int bonnusNumber) {
    int match = 0;
    boolean isIncludeBonnus = false;
    for (int i : winnerLotto.getNumbers()) {
      if (lotto.getNumbers().contains(i)) {
        match++;
      }
    }
    if (lotto.getNumbers().contains(bonnusNumber)) {
      match++;
      isIncludeBonnus = true;
    }
    return getPrize(match, isIncludeBonnus);
  }

  private static Rank getPrize(int match, boolean isIncludeBonnus) {
    boolean isSecondOrThird = match == 5;
    if (isSecondOrThird) {
      if (isIncludeBonnus) {
        return Rank.SECOND;
      }
      return Rank.THIRD;
    }
    for (Rank r : Rank.values()) {
      if (match == r.getMatch()) {
        return r;
      }
    }
    return Rank.LOSE;
  }

  public static double calcReturnRate(HashMap<Rank, Integer> result, int price) {
    int profit = 0;
    for (Rank i : result.keySet()) {
      profit += i.getPrizeMoney() * result.get(i);
    }
    double rate = 100 * profit / (double) price;
    return rate;
  }
}
