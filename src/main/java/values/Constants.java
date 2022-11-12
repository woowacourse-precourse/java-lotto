package values;

public class Constants {
    public static class Console {
        public static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
        public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
        public static final String OUTPUT_CNT = "개를 구매했습니다.";
        public static final String STATISTICS = "당첨 통계\n---";

        public String getTotalRevenueMessage(Double percent) {
            StringBuffer message = new StringBuffer();
            String roundedPercent = String.format("%.1f", percent);

            message.append("총 수익률은 ");
            message.append(roundedPercent);
            message.append("%입니다.");

            return message.toString();
        }
    }

    public static class Error {
        public static final String RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
        public static final String DUPLICATION_ERROR = "[ERROR] 로또 번호에는 중복이 없어야 합니다.";
        public static final String SIZE_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    }
}
