package lotto;

public class CalculateTotalEarningGenerator {
    public static void calculateTotalEarning(int userMoney, int totalEarningMoney) {
        long LongTypetotalEarningMoney = totalEarningMoney;
        double earningRate = (double) (LongTypetotalEarningMoney*100)/userMoney;
        System.out.printf("총 수익률은 %.1f", earningRate);
        System.out.println("%입니다.");
    }

}
