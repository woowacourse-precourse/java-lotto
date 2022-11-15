package lotto;

import java.util.List;

public class Error {
    public enum Messages {
        PREFIX("[ERROR]"),
        LOTTO_NUMBER_PARSER_ERROR(
                String.format("로또 번호는 공백 없이 '%s'로 구분해야 합니다.", WinningLotto.PARSER)
        ),
        LOTTO_NUMBER_LENGTH_ERROR(
            String.format("로또 번호는 %d개를 입력해야 합니다.", Lotto.MAX_SIZE)
        ),
        LOTTO_NUMBER_RANGE_ERROR(
                String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", Lotto.START_NUMBER, Lotto.END_NUMBER)
        ),
        LOTTO_NUMBER_UNIQUE_ERROR(
                String.format("로또 번호는 %d부터 %d 사이의 중복되지 않은 숫자여야 합니다.", Lotto.START_NUMBER, Lotto.END_NUMBER)
        ),
        PURCHASING_AMOUNT_UNIT_ERROR(
                String.format("구입금액은 %d원 단위여야 합니다.", User.PURCHASING_UNIT)
        ),
        PURCHASING_AMOUNT_RANGE_ERROR(
                String.format(
                        "구입금액은 %d원부터 %d원 사이의 %d원 단위 숫자여야 합니다.",
                        User.MINIMUM_PURCHASING_AMOUNT,
                        User.MAXIMUM_PURCHASING_AMOUNT,
                        User.PURCHASING_UNIT
                )
        );

        private final String message;
        Messages(String message) { this.message = message; }
    }

    public static String getErrorMessage(Messages type) {
        List<String> messages = List.of(Messages.PREFIX.message, type.message);
        return String.join(" ", messages);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
