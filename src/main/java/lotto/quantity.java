package lotto;

public class quantity {

  private final String price;
  private final int price_calculation;
  public final int paper_quantity;

  public quantity(String price){
    this.price = price;
    price_calculation = Integer.parseInt(this.price);
    paper_quantity = price_calculation / 1000;
    System.out.println("\n" + paper_quantity + "개를 구매했습니다.");
  }
}
