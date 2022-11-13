package lottoMachine.enums;

import static lottoMachine.enums.Messages.ERROR_MESSAGE_PREFIX;
import static lottoMachine.enums.Messages.PRICE_UNIT_ERROR_MESSAGE;
import static lottoMachine.enums.Messages.RATE_OF_RETURN_MESSAGE;
import static lottoMachine.enums.Messages.RESULT_OF_PURCHASE_MESSAGE;
import static lottoMachine.enums.Messages.WINNING_STATISTICS_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MessagesTest {

    @Test
    void 구매_메세지_Enum이_잘_적용되는지_확인합니다() {
        String format = MessageFormat.format(RESULT_OF_PURCHASE_MESSAGE.toString(), 5);

        assertThat(format).isEqualTo("\n5개를 구매했습니다.");
    }

    @Test
    void 통계_메세지_Enum이_잘_적용되는지_확인합니다() {
        List<Integer> arguments = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arguments.add(i);
        }
        String format = MessageFormat.format(WINNING_STATISTICS_MESSAGE.toString(),
                arguments.toArray());

        assertThat(format).isEqualTo("\n당첨 통계\n"
                + "---\n"
                + "3개 일치 (5,000원) - 4개\n"
                + "4개 일치 (50,000원) - 3개\n"
                + "5개 일치 (1,500,000원) - 2개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n"
                + "6개 일치 (2,000,000,000원) - 0개");
    }

    @Test
    void 수익률_메세지_Enum이_잘_적용되는지_확인합니다() {
        double number = 0.6255;
        String format = String.format("%.1f", number * 100);
        DecimalFormat decimalFormat = new DecimalFormat("#,###.0");
        String rate = decimalFormat.format(Double.valueOf(format));
        String result = MessageFormat.format(RATE_OF_RETURN_MESSAGE.toString(), rate);

        assertThat(result).isEqualTo("총 수익률은 62.6%입니다.");
    }

    @Test
    void 에러메세지_Enum이_잘_적용되는지_확인합니다() {
        String errorMessage = ERROR_MESSAGE_PREFIX.toString() + PRICE_UNIT_ERROR_MESSAGE;

        assertThat(errorMessage).isEqualTo("[ERROR] 금액은 1000원 단위 숫자여야 합니다.");
    }

}
