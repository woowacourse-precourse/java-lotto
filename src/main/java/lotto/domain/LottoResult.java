package lotto.domain;

public enum LottoResult {
    FIRST("6개 일치 (2,000,000,000원) - ", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000),
    THIRD("5개 일치 (1,500,000) - ", 1_500_000),
    FOURTH("4개 일치 (50,000) - ", 50_000),
    FIFTH("3개 일치 (5,000) - ", 5_000),
    NOTHING("NOTHING", 0);

    String result = "";
    int prize = 0;
    LottoResult(String result, int prize) {
        this.result = result;
        this.prize = prize;
    }
}
