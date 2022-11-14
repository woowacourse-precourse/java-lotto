package lotto;

import java.util.List;

public class PrintMessage {
    public static final String buy = "구입금액을 입력해 주세요.";
    public static final String amount = "개를 구매했습니다.";

    public static final String numbers = "당첨 번호를 입력해 주세요.";
    public static final String bonus = "보너스 번호를 입력해 주세요.\n";

    public static final String statistic = "당첨 통계\n---";

    public String ticketInfo(List<List<Integer>> tickets) {
        StringBuilder ticketMessage = new StringBuilder();
        for (List<Integer> ticket : tickets) {
            ticketMessage.append("[");
            for (int number : ticket) {
                ticketMessage.append(number).append(", ");
            }
            ticketMessage.setLength(ticketMessage.length()-2);
            ticketMessage.append("]\n");
        }
        return ticketMessage.toString();
    }

    public String coincidence(Prize prize, int count) {
        StringBuilder messageBuilder = new StringBuilder("개 일치");

        if (prize == Prize.SECOND) {
            messageBuilder.append(", 보너스 볼 일치");
        }

        return messageBuilder.append(" (")
                .append(prize.reward())
                .append("원) - ")
                .append(count)
                .append("개")
                .toString();
    }


    public String benefit(double benefit) {
        return new StringBuilder("총 수익률은 ")
                .append(benefit)
                .append("%입니다.")
                .toString();
    }
}
