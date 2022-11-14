package domain;

// 등수,상금,등수 별 출력 메시지 를 담고있는 열거형 상수 클래스
public enum Prize {
    firstPrize(1, 2000000000, "6개 일치 (2,000,000,000원)"),
    secondPrize(2, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    thirdPrize(3, 1500000, "5개 일치 (1,500,000원)"),
    fourthPrize(4, 50000, "4개 일치 (50,000원)"),
    fifthPrize(5, 5000, "3개 일치 (5,000원)"),
    nothing(0, 0, "미당첨");

    public final int ranking;
    public final int rankingPrize;
    public final String systemMessage;

    Prize(int ranking, int rankingPrize, String systemMessage) {
        this.ranking = ranking;
        this.rankingPrize = rankingPrize;
        this.systemMessage = systemMessage;
    }

    public int getRanking() {
        return this.ranking;
    }

}
