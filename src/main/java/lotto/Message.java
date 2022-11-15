package lotto;

public final class Message {
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final String ERROR_CHECKNUM = " 숫자가 아닌 수가 존재합니다.";
    public static final String ERROR_CHECKPRICE = " 1000원 단위로 입력해 주세요.";
    public static final String ERROR_CHECKLOTTONUM =  " 1부터 45사이의 수가 아니다.";
    public static final String ERROR_UNIQUENUM = " 당첨번호에 중복이 발생합니다.";
    public static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String LOTTOSIZE_MESSAGE = "개를 구매했습니다.";
    public static final String WINNINGNUM_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUSNUM_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static final String OUTPUT_MESSAGE = "3개 일치 (5,000원) - %d개\n" +
            "4개 일치 (50,000원) - %d개\n" +
            "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
            "6개 일치 (2,000,000,000원) - %d개\n";
    public static final String PERCENT_MESSAGE = "총 수익률은 %.1f%%입니다.";

}
