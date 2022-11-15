package lotto.application.port.in.dto;

import java.util.List;

public class RequestMatchDto {
    private List<Integer> winningNumbers;
    private List<Integer> numbers;

    public RequestMatchDto(List<Integer> winningNumbers, List<Integer> numbers) {
        this.winningNumbers = winningNumbers;
        this.numbers = numbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
