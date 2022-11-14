package lotto;

import lotto.Lotto.Lotto;

import java.util.HashMap;
import java.util.List;

public class Message {
    public static final String GAME_START_MESSAGE = "게임시작\n";
    public static final String GAME_END_MESSAGE = "게임 종료\n";

    public static final String LOTTO_PURCHASE_REQUEST_MESSAGE = "로또 구매 금액을 입력해주세요(1장에 1000원) : ";
    public static final String INPUT_INVALID_MESSAGE_BODY = "입력 형식이 맞지 않습니다. 게임을 종료합니다.\n";
    public static final String WINNING_LOTTO_NUMBERS_INPUT_REQUEST_MESSAGE = "당첨 번호를 ','로 구분하여 입력해 주세요 : ";
    public static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요 : ";
    private static final String ERROR_HEADER = "[ERROR]";
    private static final String DELIMITER = " ";
    private static final String LOTTO_SIZE_ERROR_MESSAGE_BODY = "로또 번호의 개수는 6이여야 합니다.\n";
    private static final String LOTTO_NUMBER_OUT_OF_BOUND_ERROR_MESSAGE_BODY = "로또 번호는 1부터 45 사이의 숫자여야 합니다.\n";
    private static final String LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE_BODY = "로또 번호에 중복된 숫자가 존재합니다.\n";
    public static final String STATISTICS_MESSAGE = "--------- 당첨 통계 ---------\n";

    public static String getInputInvalidErrorMessage()
    {
        return String.join(DELIMITER,ERROR_HEADER,INPUT_INVALID_MESSAGE_BODY);
    }

    public static String getLottoSizeErrorMessage()
    {
        return String.join(DELIMITER,ERROR_HEADER,LOTTO_SIZE_ERROR_MESSAGE_BODY);
    }
    public static String getLottoNumberOutOfBoundErrorMessageBody()
    {
        return String.join(DELIMITER,ERROR_HEADER,LOTTO_NUMBER_OUT_OF_BOUND_ERROR_MESSAGE_BODY);
    }
    public static String getLottoNumberDuplicationErrorMessage()
    {
        return String.join(DELIMITER,ERROR_HEADER,LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE_BODY);
    }
    public static String getPurchaseLottoSizeMessage(List<Lotto> purchaseLotties)
    {
        return purchaseLotties.size() + "개를 구매했습니다.\n";
    }

    public static String getLottiesNumberInfoMessage(List<Lotto> lotties)
    {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lotties) {
            sb.append(lotto.toString() + "\n");
        }
        return sb.toString();
    }

    public static String getPrizeInfoMessage(List<Prize> myPrizes)
    {
        StringBuilder sb = new StringBuilder();
        HashMap<Prize,Integer> map = new HashMap<>();

        for (Prize myPrize : myPrizes) {
            Integer orDefault = map.getOrDefault(myPrize, 0);
            map.put(myPrize,orDefault+1);
        }

        List<Prize> prizeValues = Prize.getValues();
        for (Prize prizeValue : prizeValues) {
            sb.append(prizeValue.toString() + " - " + map.getOrDefault(prizeValue,0) + "개\n");
        }
        return sb.toString();
    }

    public static String getEarningMessage(double earnPercentage)
    {
        return "총 수익률은 " + earnPercentage +"%입니다.\n";
    }

}
