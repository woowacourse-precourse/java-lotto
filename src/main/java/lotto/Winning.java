package lotto;

public enum Winning {
    FIRST("6개 일치 (2,000,000,000원) - ", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    THRID("5개 일치 (1,500,000원) - ", 1500000),
    FOURTH("4개 일치 (50,000원) - ", 50000),
    FIFTH("3개 일치 (5,000원) - ", 5000);

    private final String sentence;
    public final int prize;

    Winning(String sentence, int prize) {
        this.sentence = sentence;
        this.prize = prize;
    }

    public String toString(int result) {
        return this.sentence + result + "개";
    }
}
