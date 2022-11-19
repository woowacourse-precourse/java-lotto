package model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningLotto {

    private List<String> winningNumbers;
    private List<Integer> winningNumbersConvert;

    public WinningLotto(String input) {
        setWinningNumberBasedOnComma(input);
        this.winningNumbersConvert = winningNumbersConvert;
    }

    public void setWinningNumberBasedOnComma(String input) {
        winningNumbers = Stream.of(input.split("\\s*,\\s*"))
                .collect(Collectors.toList());

        winningNumbersConvert = winningNumbers.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbersConvert;
    }

}
