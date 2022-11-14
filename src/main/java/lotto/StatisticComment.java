package lotto;

public enum StatisticComment {
    GOT_SIX("6개 일치 (2,000,000,000원) - "),
    GOT_FIVE_W_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    GOT_FIVE("5개 일치 (1,500,000원) - "),
    GOT_FOUR("4개 일치 (50,000원) - "),
    GOT_THREE("3개 일치 (5,000원) - ");

    final String comment;

    StatisticComment(String comment) {
        this.comment = comment;
    }
}
