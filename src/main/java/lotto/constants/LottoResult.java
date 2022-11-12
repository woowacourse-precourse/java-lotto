package lotto.constants;

public enum LottoResult {
    ThreeCorrect(3, 5_000),
    FourCorrect(4, 50_000),
    FiveCorrect(5, 1_500_000),
    FiveCorrectWithBonus(5, 30_000_000),
    SixCorrect(6, 2_000_000_000),
    UNDERThree(0, 0);

    private int prize;
    private int correctCount;

    LottoResult(int correctCount, int prize) {
        this.prize = prize;
        this.correctCount = correctCount;
    }

    public static int getPrizeByCorrectCount(int correctCount) {
        LottoResult[] lottoResults = LottoResult.values();
        for (LottoResult l : lottoResults) {
            if (l.getCorrectCount() == correctCount) {
                return l.getPrize();
            }
        }
        return UNDERThree.getPrize();
    }

    private int getPrize() {
        return prize;
    }

    private int getCorrectCount() {
        return correctCount;
    }

}
