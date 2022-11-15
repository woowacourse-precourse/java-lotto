package lotto.lotto;

public class LottoPrinter {
    private int[] matched;

    public LottoPrinter() {
        matched = new int[6];
    }


    public void printLottoResult() {
        System.out.printf("3개 일치 (5,000원) - %d개\n"
                + "4개 일치 (50,000원) - %d개\n"
                + "5개 일치 (1,500,000원) - %d개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
                + "6개 일치 (2,000,000,000원) - %d개\n",
            matched[0], matched[1], matched[2], matched[3], matched[4]);
    }

    public void addResult(int matchedBalls, boolean bonusMatched) {
        if (matchedBalls == 3)
            matched[0] += 1;
        else if (matchedBalls == 4)
            matched[1] += 1;
        else if (matchedBalls == 5 && !bonusMatched)
            matched[2] += 1;
        else if (matchedBalls == 5 && bonusMatched)
            matched[3] += 1;
        else if (matchedBalls == 6)
            matched[4] += 1;
    }
}
