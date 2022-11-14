package lotto;

public class message {
    public interface gameMessages {
        String AMOUNT_MONEY_INPUT = "구입금액을 입력해 주세요.";
        String PURCHASE_AMOUNT = "개를 구매했습니다.";
        String WIN_LOTTO_NUMBER_INPUT = "\n"+"당첨 번호를 입력해 주세요.";
        String BONUS_NUMBER_INPUT = "\n"+"보너스 번호를 입력해 주세요.";
    }

    public interface errorMessages {
        String USER_INPUT_ERROR = "[ERROR] 잘못된 입력입니다.";
        String ALREADY_EXISTED_NUMBER = "[ERROR] 이미 입력된 로또번호가 있습니다.";
        String INPUT_RANGE_ERROR = "[ERROR] 잘못된 범위의 값을 입력했습니다.";
    }

    public interface resultMessages {
        int FIRST_PRIZE = 2000000000;
        int SECOND_PRIZE = 30000000;
        int THIRD_PRIZE = 1500000;
        int FOURTH_PRIZE = 50000;
        int FIFTH_PRIZE = 5000;

        String RESULT_STATS = "당첨통계"+"\n"+"---";

        String FIRST_RESULT = "6개 일치 (2,000,000,000원) - ";
        String SECOND_RESULT = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
        String THIRD_RESULT = "5개 일치 (1,500,000원) - ";
        String FOURTH_RESULT = "4개 일치 (50,000원) - ";
        String FIFTH_RESULT = "3개 일치 (5,000원) - ";

        String UNIT = "개";

        String YIELD_RESULT_START = "총 수익률은 ";
        String YIELD_RESULT_END = "%입니다.";
    }
}
