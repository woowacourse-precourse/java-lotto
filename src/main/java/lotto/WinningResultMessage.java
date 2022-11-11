package lotto;

public enum WinningResultMessage {
    FIFTH_PLACE(LottoRank.FIFTH_PLACE, "3개 일치 (5,000원) - "),
    FOURTH_PLACE(LottoRank.FOURTH_PLACE, "4개 일치 (50,000원) - "),
    THIRD_PLACE(LottoRank.THIRD_PLACE, "5개 일치 (1,500,000원) - "),
    SECOND_PLACE(LottoRank.SECOND_PLACE, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_PLACE(LottoRank.FIRST_PLACE, "6개 일치 (2,000,000,000원) - ");

    private final LottoRank lottoRank;
    private final String message;

    WinningResultMessage(LottoRank lottoRank, String message) {
        this.lottoRank = lottoRank;
        this.message = message;
    }

    public void print(int count) {
        System.out.println(message + count + "개");
    }

    public LottoRank getLottoRank() {
        return lottoRank;
    }
}
