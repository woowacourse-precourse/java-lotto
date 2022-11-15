package lotto.ui;

import java.util.List;

public class InformationMessage {
    private static final String BEFORE_BUY_MSG = "구입금액을 입력해 주세요.";
    private static final String AFTER_BUY_MSG = "개를 구매했습니다.";
    private static final String BEFORE_WINNING_NUMBER_INPUT_MSG = "당첨 번호를 입력해 주세요.";
    private static final String BEFORE_BONUS_NUMBER_INPUT_MSG = "보너스 번호를 입력해 주세요.";
    private static final String BEFOER_RESULT_PRINT_MSG = "당첨 통계\n---";
//    
//    
//    private static final String FIFTH_MSG = "3개 일치 (5,000원) - ";
//    private static final String FOURTH_MSG = "4개 일치 (50,000원) - ";
//    private static final String THIRD_MSG = "5개 일치 (1,500,000원) - ";
//    private static final String SECOND_MSG = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
//    private static final String FIRST_MSG = "6개 일치 (2,000,000,000원) - ";
//    private static final String UNIT_OF_COUNT_MSG = "개";
    private static final String TOTAL_REWARD_PERCENT_MSG = "총 수익률은 ";
    
    public InformationMessage(){
    }
    
    public void printBeforeBuyMessage() {
        System.out.println(BEFORE_BUY_MSG);
    }
    
    public void printAfterBuyMessage(int n) {
        System.out.println(n + AFTER_BUY_MSG);
    }
    
    public void printLottoNumber(List<Integer> numbers) {
        String str = "[";
        for(int i = 0; i < numbers.size(); i++) {
            str += numbers.get(i) + ", ";
        }
        str += "]";
        System.out.println(str);
    }
    
    public void printBeforeWinningNumberInputMessage() {
        System.out.println(BEFORE_WINNING_NUMBER_INPUT_MSG);
    }
    
    public void printBeforeBonusNumberInputMessage() {
        System.out.println(BEFORE_BONUS_NUMBER_INPUT_MSG);
    }
    
    public void printBeforeResultMessage() {
        System.out.println(BEFOER_RESULT_PRINT_MSG);
    }
    
    public void printResult(int[] cnt) {
        for(int i = 0; i < cnt.length; i++) {
            LottoResultMsg lottoResultMsg = LottoResultMsg.findByOrdinal(i);
            System.out.println(lottoResultMsg.getStr() + cnt[i] + "개");
        }
    }
    
    public void printTotalRewardPercent(double percent) {
        System.out.println(TOTAL_REWARD_PERCENT_MSG + percent + "%입니다.");
    }
}
