package lotto;

public class CalculateTotalEarningGenerator {
    public static void calculateTotalEarning(int userMoney, int totalEarningMoney) {
        double earningRate = (double) (totalEarningMoney*100)/userMoney;
        System.out.printf("총 수익률은 %.1f", earningRate);
        System.out.println("%입니다.");
    }

}
