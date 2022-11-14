package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class victory {
  public final String victory_normal_number;
  public final String victory_bonus_number;
  public victory(){
    //로또 당첨번호 받기
    System.out.println("\n당첨 번호를 입력해 주세요.");
    victory_normal_number = Console.readLine().trim();
    victory_check(victory_normal_number);
    System.out.println(victory_normal_number);
    //로또 당첨번호 보너스번호 받기
    System.out.println("\n보너스 번호를 입력해 주세요.");
    victory_bonus_number = Console.readLine().trim();
    //victory_check(victory_bonus_number);
    System.out.println(victory_bonus_number);
  }
  private void victory_check(String check_number){
    String[] new_check_number = check_number.split(",");
    List<Integer> trans_check_number = Arrays.stream(new_check_number)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    Lotto check = new Lotto(trans_check_number);
  }
}
