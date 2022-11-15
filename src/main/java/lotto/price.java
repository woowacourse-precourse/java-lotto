package lotto;

import camp.nextstep.edu.missionutils.Console;

public class price {
  public final String input_price;
  public int program_out = 0;
  public price(){
    System.out.println("구매금액을 입력해 주세요.");
    input_price = Console.readLine().trim();
    System.out.println(input_price);
    No_Number(input_price);
    if(program_out == 0) under_price(input_price);
  }
  private void No_Number(String ch_price){
    if (!ch_price.matches("-?\\d+(\\.\\d+)?")) {
      System.out.println("[ERROR] 숫자를 입력해주세요.");
      program_out = 1;
    }
  }
  private void under_price(String ch_price){
    int new_ch_price = Integer.parseInt(ch_price);
    if (new_ch_price < 1000) {
      System.out.println("[ERROR] 1000원 이상 넣어야 1장 이상 살 수 있습니다.");
      program_out = 1;
    }
  }
}
