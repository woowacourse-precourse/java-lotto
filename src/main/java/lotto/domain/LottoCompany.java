package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 당첨 번호 발표
 */
public class LottoCompany {
    public Lotto drawWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<String> winningNumbers = Arrays.asList(readLine().split(","));
        validateNumeric(winningNumbers);
        return new Lotto(winningNumbers.stream()
                .map(n -> Integer.parseInt(n))
                .collect(Collectors.toList()));
    }

    private void validateNumeric(List<String> numbers) {
        for (String number : numbers) {
            if (!number.matches("^[0-9]+$")) {
                System.out.println("[ERROR] 로또 번호는 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }
}
