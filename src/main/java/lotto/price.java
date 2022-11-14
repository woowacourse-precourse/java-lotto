package lotto;

import camp.nextstep.edu.missionutils.Console;

public class price {
  public final String input_price;
  public int program_out = 0;
  public price(){
    System.out.println("구매금액을 입력해 주세요.");
    input_price = Console.readLine().trim();
    System.out.println(input_price);
    check_price(input_price);
  }
  private void check_price(String ch_price){
    if (!ch_price.matches("-?\\d+(\\.\\d+)?")) {
      System.out.println("[ERROR]");
      program_out = 1;
    }
  }
}
