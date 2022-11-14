package lotto.domain;

public class Statistics {

    public final String rateOfReturn;
    public final String resultMessage;

    public Statistics(int firstCount, int secondCount, int thirdCount, int fourthCount, int fifthCount) {
        this.rateOfReturn = statisticsReturn(firstCount, secondCount, thirdCount, fourthCount, fifthCount);
        this.resultMessage = statisticsMessage(firstCount, secondCount, thirdCount, fourthCount, fifthCount);
    }

    private String statisticsReturn(int firstCount, int secondCount, int thirdCount, int fourthCount, int fifthCount) {
        String rate = "";
        return rate;
    }

    private String statisticsMessage(int firstCount, int secondCount, int thirdCount, int fourthCount, int fifthCount) {
        String message = "";
        message += "당첨 통계\n---\n"
                + "3개 일치 (5,000원) - " + fifthCount + "개\n"
                + "4개 일치 (50,000원) - " + fourthCount +"개\n"
                + "5개 일치 (1,500,000원) - " + thirdCount +"개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondCount +"개\n"
                + "6개 일치 (2,000,000,000원) - " + firstCount +"개\n"
                + "총 수익률은 " + rateOfReturn + "%입니다.\n";
        return message;
    }
}
