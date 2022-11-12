package lotto;

public class Constant {
    // 당첨 랭크별 일치 수
    public static final int firstRankNum = 6;
    public static final int secondRankNum = 5;
    public static final int thirdRankNum = 5;
    public static final int fourthRankNum = 4;
    public static final int fifthRankNum = 3;

    // 당첨 랭크별 상금 (int)
    public static final int firstRankPrice = 2000000000;
    public static final int secondRankPrice = 30000000;
    public static final int thirdRankPrice = 1500000;
    public static final int fourthRankPrice = 50000;
    public static final int fifthRankPrice = 5000;

    // 당첨 랭크별 상금 (String)
    public static final String firstRankPriceString = "2,000,000,000";
    public static final String secondRankPriceString = "30,000,000";
    public static final String thirdRankPriceString = "1,500,000";
    public static final String fourthRankPriceString = "50,000";
    public static final String fifthRankPriceString = "5,000";

    // 출력 문자열
    public static final String inputPrice = "구입금액을 입력해 주세요.";
    public static final String inputWinningLotto = "당첨 번호를 입력해 주세요.";
    public static final String inputBonusNum = "보너스 번호를 입력해 주세요.";
    public static final String inputWinningStats = "당첨 통계";

    // 출력 문자열 format
    public static final String buyingFormat = "%d개를 구매했습니다.\n";
    public static final String winningFormat = "%d개 일치 (%s원) - %d개\n";
    public static final String winningFormatBonus = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    public static final String earningRateFormat = "총 수익률은 %f";
    public static final String earningRateConcatFormat = "%입니다.";

}
