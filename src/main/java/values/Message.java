package values;

public class Message {
    static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    static final String OUTPUT_CNT = "개를 구매했습니다.";
    static final String STATISTICS = "당첨 통계\n---";

    public String getTotalRevenueMessage(Double percent){
        StringBuffer message = new StringBuffer();
        String roundedPercent = String.format("%.1f", percent);

        message.append("총 수익률은 ");
        message.append(roundedPercent);
        message.append("%입니다.");

        return message.toString();
    }
}
