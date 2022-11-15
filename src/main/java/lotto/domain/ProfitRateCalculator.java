package lotto.domain;


import java.util.List;

public class ProfitRateCalculator {

  private static final int LOTTO_PRICE = 1000;

  public double calculate(List<LottoPrize> result) {
    double sumMoney = result.size() * LOTTO_PRICE;
    double totalPrizeMoney = priceTotalMoney(result);
    double cal = totalPrizeMoney / sumMoney * 100;
    String format = String.format("%.1f",cal);
    return Double.parseDouble(format);
  }

  private double priceTotalMoney(List<LottoPrize> result) {
    return result.stream().map(LottoPrize::getMoney)
        .mapToInt(i -> i).sum();
  }

}
