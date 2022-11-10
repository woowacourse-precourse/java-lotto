package lotto;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MemberWriteService {

    // 금액 입력 기능
    public int writePay(String writePay) {
        try {
            return Integer.parseInt(writePay);
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }



}
