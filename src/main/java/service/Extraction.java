package service;

import common.message.ErrorMessage;
import exception.InputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Extraction {

    public static List<Integer> extractWinningNumbers(String input) {
        List<Integer> winningNumbers;
        try {
            winningNumbers = Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            InputException.validateWinningNumbers(winningNumbers);
            return winningNumbers;
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder(ErrorMessage.EXCEPTION_START.getValue());
            sb.append(ErrorMessage.EXCEPTION_ONLY_NUMERIC.getValue());
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
