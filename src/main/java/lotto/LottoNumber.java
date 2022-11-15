package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoNumber {

  public static List<Integer> Lottonumber;

  LottoNumber(){
    String[] numbers = Console.readLine().split(",");
    for(int i=0; i<6; i++){
      Lottonumber.add(Integer.parseInt(numbers[i]));
    }
    new Lotto(Lottonumber);
    int bonusnumber = Integer.parseInt(Console.readLine());
    if(bonusnumber < 1 || bonusnumber > 45){
      throw new IllegalArgumentException();
    }
    if(Lottonumber.contains(bonusnumber)){
      throw new IllegalArgumentException();
    }
  }
}
