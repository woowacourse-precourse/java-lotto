package lotto.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class WinnerNumberDto {

    private final List<Integer> winnerNumbers;
    private final int bonusNumber;

    public WinnerNumberDto(String winnerNumber, String bonusNumber) {
        this.winnerNumbers = new ArrayList<>();
        this.bonusNumber = 0;
    }
}
