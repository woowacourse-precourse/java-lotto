package lotto.global.message;

public interface TextMessage {

    String REQUEST_MONEY = "구입금액을 입력해 주세요.";
    String REQUEST_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    String REQUEST_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    String SEND_STATISTICS = "\n당첨 통계\n" + "---";

    String STATISTICS_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    String STATISTICS_FORMAT = "%d개 일치 (%s원) - %d개";
    String PROFIT_FORMAT_PREFIX = "총 수익률은 ";
    String PROFIT_FORMAT_SUFFIX = "%입니다.";

    static String sendLottosCount(Integer count) {
        return "\n" + count + "개를 구매했습니다.";
    }

    static String sendProfit(Double rate) {
        return PROFIT_FORMAT_PREFIX + rate + PROFIT_FORMAT_SUFFIX;
    }
}
