package lotto;

import java.util.List;

public class Score {
  int[] ranking;

  public Score(List<List<Integer>> lottoRepository, List<Integer> numbers, Integer num) {
    this.ranking = new int[6];
    compareLottoRepository(lottoRepository, numbers, num);
  }

  public void compareLottoRepository(List<List<Integer>> lottoRepository, List<Integer> numbers, Integer num){
    for (List<Integer> lotto : lottoRepository){
      int totalCount = compareNumber(lotto, numbers, num);
      calculateRanking(totalCount);
    }
  }

  public int compareNumber(List<Integer> lotto, List<Integer> numbers, Integer num){
    int totalCount = 0;

    for (Integer n : lotto){
      if (numbers.contains(n)){
        totalCount += 10;
      }
    }

    if (totalCount == 50 && numbers.contains(num)){
      totalCount += 1;
    }

    return totalCount;
  }

  public void calculateRanking(int totalCount){
    if (totalCount == Grade.FIRST.getCorrectCount()){
      ranking[1] += 1;
    }
    if (totalCount == Grade.SECOND.getCorrectCount()){
      ranking[2] += 1;
    }
    if (totalCount == Grade.THIRD.getCorrectCount()){
      ranking[3] += 1;
    }
    if (totalCount == Grade.FOURTH.getCorrectCount()){
      ranking[4] += 1;
    }
    if (totalCount == Grade.FIFTH.getCorrectCount()){
      ranking[5] += 1;
    }
  }
}
