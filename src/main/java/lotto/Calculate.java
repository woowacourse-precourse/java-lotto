package lotto;

public class Calculate {

    // 수익률을 계산하는 기능
    public static String getProfitRate(long purchaseAmount, long winningAmount) {
        return String.format("%.1f", (double) winningAmount / purchaseAmount * 100);
    }
}
