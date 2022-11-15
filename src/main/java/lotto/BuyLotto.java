package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class BuyLotto {

  private final int LottoCount;
  static List<List<Integer>> Lottos;

  BuyLotto(){
    int money = Integer.parseInt(Console.readLine());
    if(money % 1000 != 0){
      throw new IllegalArgumentException();
    }
    this.LottoCount = money / 1000;
  }

  void generateLottos(){
    for(int i=0; i<LottoCount; i++){
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
      Lottos.add(numbers);
    }
  }

  void matchLottos(){
    for(int i=0; i<LottoCount; i++){

    }
  }

  void matchLotto(List<Integer> Lotto){
    int match_count_3 = 0;
    int match_count_4 = 0;
    int match_count_5 = 0;
    int match_count_bonus = 0;
    int match_count_6 = 0;
    for(int i=0; i<6; i++){
      int match_count = 0;
      if(LottoNumber.Lottonumber.contains(Lottos.get(i))){
        match_count++;
      }
      if(match_count == 3) match_count_3++;
      else if(match_count == 4) match_count_4++;
      else if(match_count == 5 ) match_count_5++;

    }
    System.out.println(String.format("3개 일치 (5,000원) - %d개", match_count_3));
    System.out.println("4개 일치 (5,000원) - %d개");
    System.out.println("5개 일치 (5,000원) - %d개");
    System.out.println("5개 일치, 보너스 볼 일치 (5,000원) - %d개");
    System.out.println("3개 일치 (5,000원) - %d개");
  }
}
