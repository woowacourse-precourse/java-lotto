package lotto;

import camp.nextstep.edu.missionutils.Console;

public class victory {
  String victory_normal_number;
  String victory_bonus_number;
  public victory(){
    //로또 당첨번호 받기
    System.out.println("\n당첨 번호를 입력해 주세요.");
    victory_normal_number = Console.readLine().trim();
    //Lotto check = new Lotto(victory_normal_number);
    System.out.println(victory_normal_number);
    //로또 당첨번호 보너스번호 받기
    System.out.println("\n보너스 번호를 입력해 주세요.");
    victory_bonus_number = Console.readLine().trim();
    //Lotto check2 = new Lotto(victory_bonus_number);
    System.out.println(victory_bonus_number);
  }
}
