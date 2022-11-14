package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Pick {

  private final int count;
  static List<List<Integer>> pick_member = new ArrayList<>();

  public Pick(int count) {
    this.count = count;
    while(pick_member.size() < this.count){
      pick_number();
    }

  }
  //숫자뽑기
  private void pick_number(){
    List<Integer> sample_number =  pickUniqueNumbersInRange(1,46,6);
    if(repeated(sample_number)){
      pick_member.add(sample_number);
      System.out.println(sample_number.toString());
    }
  }
  // 중복 숫자 확인
  private boolean repeated(List<Integer> numbers) {
    HashSet<Integer> check_repeat = new HashSet<>(numbers);
    if (numbers.size() == check_repeat.size()) {
      return true;
    }
    return false;
  }
}
