package lotto.util;

public enum WinningResultMessage {
    FIFTH_PLACE(LottoRank.FIFTH_PLACE, "3개 일치 (5,000원) - %d개"),
    FOURTH_PLACE(LottoRank.FOURTH_PLACE, "4개 일치 (50,000원) - %d개"),
    THIRD_PLACE(LottoRank.THIRD_PLACE, "5개 일치 (1,500,000원) - %d개"),
    SECOND_PLACE(LottoRank.SECOND_PLACE, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_PLACE(LottoRank.FIRST_PLACE, "6개 일치 (2,000,000,000원) - %d개");

    private final LottoRank lottoRank;
    private final String message;

    WinningResultMessage(LottoRank lottoRank, String message) {
        this.lottoRank = lottoRank;
        this.message = message;
    }

    public void print(int count) {
        System.out.printf((message) + "%n", count);
    }

    public LottoRank getLottoRank() {
        return lottoRank;
    }
}
