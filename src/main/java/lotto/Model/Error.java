package lotto.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum Error {

    Error_msg("[ERROR] "),
    No_input("입력을 하지 않았습니다."),

    Invalid_lotto("번호 수가 유효하지 않습니다. | 입력 개수 : "),
    Dup_nbr("중복된 로또 번호를 입력하셨습니다. | 중복 번호 : "),
    No_number("숫자가 아닌 값을 입력하셨습니다. | 입력 : "),
    Amount_error("1000원 단위로 구매하실 수 있습니다. | 입력 : "),
    No_boundary("유효하지 않은 숫자를 입력하셨습니다. | 입력 : "),
    Dup_bonus("당첨번호와 중복인 보너스 번호를 입력하였습니다. | 당첨 번호: "),
    Invalid_nbr("올바른 로또 번호를 입력 해 주세요. | 입력 : ");

    private final String message;

    Error(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String getErrorMessage(final Error errorMessage) {
        return Error_msg.getMessage() + errorMessage.getMessage();
    }
    public static String getErrorMessage(final Error errorMessage, final Set<Integer> errorNumbers) {
        List<Integer> errorNumber = new ArrayList<>(errorNumbers);
        Collections.sort(errorNumber);
        return Error_msg.getMessage() + errorMessage.getMessage()
                + errorNumber.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    public static void printError(final Exception e) {
        System.out.println(e.getMessage());
    }
}
