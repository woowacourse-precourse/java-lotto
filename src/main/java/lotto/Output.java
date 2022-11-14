package lotto;

public class Output {

    private static final String INPUT_MONEY="구입금액을 입력해 주세요.\n";
    private static final String WRITE_PURCHASE_COUNT="개를 구매했습니다.";
    private static final String INPUT_WINNING_NUM="당첨 번호를 입력해 주세요.\n";
    private static final String INPUT_BONUS_NUM="보너스 번호를 입력해 주세요.\n";
    private static final String STATISTIC_OUTPUT= "당첨 통계\n"+ "---\n";
    public static void printWinningStatistic(){
        System.out.println(STATISTIC_OUTPUT);
    }
    public static void printProfit(int profit){
        System.out.println("총 수익률은 "+profit+"%입니다.\n");
    }
}
