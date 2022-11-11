package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    public int purchaseAmount() {

        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public List enterWinningNumber() {

        String str = readLine();

        List<String> winningNumber = Stream.of(str.split("\\s*,\\s*"))
                .collect(Collectors.toList());

        enterWinningNumberValidation(winningNumber);

        return winningNumber.stream().map(value -> Integer.parseInt(value)).collect(Collectors.toList());

    }

    private void enterWinningNumberValidation(List<String> winningNumber) {
        HashSet set = new HashSet(winningNumber);

        if (set.size() != winningNumber.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
        }

        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리 숫자를 입력해주세요");
        }

        for (String s : winningNumber) {
            if (1 > Integer.parseInt(s) || 45 < Integer.parseInt(s)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public int enterBonusNumber(List<Integer> winningNumber) {

        int bonusNumber = Integer.parseInt(readLine());

        enterBonusNumberValidation(winningNumber, bonusNumber);

        return bonusNumber;
    }

    private void enterBonusNumberValidation(List<Integer> winningNumber, int bonusNumber) {

        for (Integer number : winningNumber) {
            if (bonusNumber == number) {
                throw new IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호가 중복됩니다.");
            }
        }

        if (1 > bonusNumber || 45 < bonusNumber) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
