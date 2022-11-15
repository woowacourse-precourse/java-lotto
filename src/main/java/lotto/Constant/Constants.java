package lotto.Constant;

public final class Constants {
    public static final class Error {
        public static final String THOUSAND_UNIT = "[ERROR] 1000원 단위로 입력해주세요";
        public static final String NUMBER = "[ERROR] 숫자만 입력해주세요.";
        public static final String DUPLICATE = "[ERROR] 중복된 숫자 없게 입력해주세요.";
        public static final String ONE_TO_FORTYFIVE = "[ERROR] 1~45숫자만 입력해주세요.";
        public static final String SIZE = "[ERROR] 6개의 숫자를 입력해주세요.";
        public static final String MONEY = "[ERROR] 1,000원 ~ 2,147,483,000원 까지 구매 가능합니다.";
    }

    public static final class Message {
        public static final String START = "구입금액을 입력해 주세요.";
        public static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
        public static final String BONUS_NUMBER = "보너스 번호를 입력해주세요.";
        public static final String BUY_AMOUNT = "개를 구매했습니다.";
        public static final String STATISTICS_MESSAGE = "\n당첨 통계\n---";
        public static final String MONEY_MESSAGE1 = "총 수익률은 ";
        public static final String MONEY_MESSAGE2 = "%입니다.";
    }

    public static final class ResultMessage {
        public static final String THREE_MATCH = "3개 일치 (5,000원) - ";
        public static final String FOUR_MATCH = "4개 일치 (50,000원) - ";
        public static final String FIVE_MATCH = "5개 일치 (1,500,000원) - ";
        public static final String FIVE_B_MATCH = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
        public static final String SIX_MATCH = "6개 일치 (2,000,000,000원) - ";
        public static final String AMOUNT = "개";
    }

    public static final class Number {
        public static final int THOUSAND_UNIT = 1000;
        public static final int ZERO = 0;
        public static final int START_NUM = 1;
        public static final int END_NUM = 45;
        public static final int LIST_SIZE = 6;
        public static final int FIVE_MATCH = 5;
        public static final int TWO_MATCH = 2;
    }
}
