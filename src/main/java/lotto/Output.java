package lotto;

public class Output {
    public void WinnerStatistics(Integer[] winStatistics, int purchaseAmount) {
        System.out.println(Message.WIN_STATISTICS.getMessage());
        System.out.println("---");
        System.out.println(Message.WIN_5TH.getMessage() + winStatistics[0] + "개");
        System.out.println(Message.WIN_4TH.getMessage() + winStatistics[1] + "개");
        System.out.println(Message.WIN_3TH.getMessage() + winStatistics[2] + "개");
        System.out.println(Message.WIN_2TH.getMessage() + winStatistics[3] + "개");
        System.out.println(Message.WIN_1TH.getMessage() + winStatistics[4] + "개");
        System.out.println("총 수익률은 " + earningRate(winStatistics, purchaseAmount) + "%입니다.");
    }

    private double earningRate(Integer[] winStatistics, int purchaseAmount) {
        double earning = 5000 * winStatistics[0] +
                        50000 * winStatistics[1] +
                        1500000 * winStatistics[2] +
                        30000000 * winStatistics[3] +
                        2000000000 * winStatistics[4];

        return earning / (purchaseAmount * 10);
    }
}
