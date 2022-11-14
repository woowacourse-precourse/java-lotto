package lotto.global.message;

public interface TextMessage {

    String REQUEST_MONEY = "구입금액을 입력해 주세요.";
    String REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    static String sendLottosCount(Integer count) {
        return count + "개를 구매했습니다.";
    }
}
