package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NotificationTest {
    @DisplayName("로또 구매 갯수가 8개인 경우 출력 테스트")
    @Test
    void notificationPurchaseCount() {
        assertThat(String.format(Notification.PURCHASE_COUNT.getMessage(), 8))
                .contains("8개를 구매했습니다.");
    }

    @DisplayName("로또 당첨 결과 1, 1, 1, 1, 1으로 10.0% 수익인 경우 당첨 결과 출력 테스트")
    @Test
    void notificationLottoResult() {
        assertThat(String.format(Notification.LOTTO_RESULT.getMessage(), 1, 1, 1, 1, 1, "10.0%"))
                .contains("당첨 통계",
                        "---",
                        "3개 일치 (5,000원) - 1개",
                        "4개 일치 (50,000원) - 1개",
                        "5개 일치 (1,500,000원) - 1개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                        "6개 일치 (2,000,000,000원) - 1개",
                        "총 수익률은 10.0%입니다.");
    }
}
