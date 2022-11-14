package lotto;

import java.util.List;

public class price {

  private final String input_price;

  public price(String input_price){
    this.input_price = input_price;
    if (!this.input_price.matches("[+-]?\\d*(\\.\\d+)?")) {
      throw new IllegalArgumentException();
    }
  }
}
