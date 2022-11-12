package lotto.view;

public class Play {
    public static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String CHECK_MESSAGE = "개를 구매했습니다.";
    public static final String INPUT_WINNING_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_MESSAGE = "당첨 통계\n" +"---";
    public static final String RATE_MESSAGE = "총 수익률은 %f%입니다.";

    public void startPlay(){
        System.out.println(START_MESSAGE);

    }

}
