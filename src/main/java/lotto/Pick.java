package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Pick {

  private final int count;
  public List<List<Integer>> pick_member = new ArrayList<>();

  public Pick(int count) {
    this.count = count;
    while(pick_member.size() < this.count){
      pick_number();
    }

  }
  //숫자뽑기 및 6자리 확인 및 중복확인
  private void pick_number(){
    //숫자뽑기
    List<Integer> sample_number =  pickUniqueNumbersInRange(1,46,6);
    //6자리 확인 및 중복확인
    Lotto check_pick_number = new Lotto(sample_number);
    pick_member.add(sample_number);
    System.out.println(sample_number.toString());
  }
}
