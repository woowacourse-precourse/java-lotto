package lotto.domain;

public enum LottoGrade {

    fifth(5_000, 3),
    fourth(50_000, 4),
    third(1_500_000, 5),
    second(30_000_000, 5),
    first(2_000_000_000, 6);

    private int prize;
    private int correct;

    LottoGrade(int prize, int correct) {
        this.prize = prize;
        this.correct = correct;
    }

    public static LottoGrade getGrade(int correctOfLotto, boolean bonus) {

        for (LottoGrade lottoGrade : values()) {
            if (correctOfLotto == 5 && bonus) {
                return LottoGrade.second;
            }
            if (lottoGrade.correct == correctOfLotto) {
                return lottoGrade;
            }
        }
        return null;
    }

    public int getPrize() {
        return prize;
    }

    public int getCorrect() {
        return correct;
    }
}
