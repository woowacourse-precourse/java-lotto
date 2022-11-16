package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        // 6자리가 아니면 예외처리
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6자리여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리여야 합니다.");
        }
        // 중복된 값이 있으면 예외처리
        if (numbers.stream().distinct().collect(Collectors.toList()).size() != 6) {
            System.out.println("[ERROR] 로또 번호에 중복된 값이 존재합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 값이 존재합니다.");
        }
    }

    // 로또 당첨을 체크하는 메소드
    // TODO 15줄로 줄이기
    public int winningCheck(List<Integer> winningNumberList) {
        int winningCount = 0;
        for (int thisIndex = 0, winningIndex = 0; thisIndex < numbers.size() && winningIndex < winningNumberList.size(); thisIndex++, winningIndex++) {
            if (numbers.get(thisIndex) < winningNumberList.get(winningIndex)) {
                winningIndex--;
                continue;
            }
            if (winningNumberList.get(winningIndex) < numbers.get(thisIndex)) {
                thisIndex--;
                continue;
            }
            winningCount++;
        }
        return winningCount;
    }

    // 보너스 번호를 체크하는 메소드
    public boolean bonusCheck(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
