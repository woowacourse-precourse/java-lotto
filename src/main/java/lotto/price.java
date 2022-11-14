package lotto;

import java.util.List;

public class price {
  private final String input_price;
  int program_out = 0;
  public price(String input_price){
    this.input_price = input_price;
    if (!this.input_price.matches("-?\\d+(\\.\\d+)?")) {
        System.out.println("[ERROR]");
      program_out = 1;
    }
  }
}
