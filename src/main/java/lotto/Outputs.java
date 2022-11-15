package lotto;

public class Outputs {

    public static void printWinningDetails(){
        System.out.println("당첨 통계");
        System.out.println("---");

        for(WinningResult result: WinningResult.values()){
            result.print();
        }
    }

    public static void printEarningRatio(Purchaser purchaser){
        double earningRatio = Math.round(
                purchaser.totalEarns / (double)purchaser.cost * 1000.0)
                / 1000.0 * 100;
        System.out.format("총 수익률은 %,.1f%%입니다.\n", earningRatio);
    }

}
