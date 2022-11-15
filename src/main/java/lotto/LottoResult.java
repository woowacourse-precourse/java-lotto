package lotto;

public class LottoResult {

    private int totalProceeds;
    private MatchCount matchCount;
    private static final String INCOME_RESULT = "총 수익률은 ";
    private static final String END_SENTENCE = "%입니다.";

    LottoResult(){
        totalProceeds = 0;
    }

    public void getLottoResult(int[] winningInformation, int userPrice){
        for(int i=0;i<5;i++){
            MatchCount matchInformation = matchCount.valueOfNumber(i);

            String label = matchInformation.label();
            totalProceeds += sumWinningCost(matchInformation, winningInformation[i]);

            System.out.println(label + winningInformation[i] + "개");
        }
        double rate = ((double)totalProceeds / (double)userPrice) * 100;
        System.out.println(INCOME_RESULT + String.format("%.1f", rate) + END_SENTENCE);
    }

    private int sumWinningCost(MatchCount information, int matchCnt){
        return information.proceeds() * matchCnt;
    }
}
