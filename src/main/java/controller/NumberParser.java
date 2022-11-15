package controller;

import data.ExceptionData;
import data.NumericData;
import java.util.ArrayList;
import java.util.List;

public class NumberParser {


    /**
     * NumberParserTest.java 테스트용 생성자
     *
     * @param winningNumbers 당첨 번호 리스트
     */
    public NumberParser(List<Integer> winningNumbers) {
        validate(winningNumbers);
    }

    /**
     * NumberParserTest.java 테스트용 생성자
     *
     * @param number 보너스 번호
     */
    public NumberParser(int number) {
        validate(number);
    }

    public NumberParser() {
    }

    public List<Integer> setWinningNumbers(String rawNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] splittedNumbers = rawNumbers.split(",");
        try {
            for (String number : splittedNumbers) {
                winningNumbers.add(Integer.parseInt(number));
            }
        } catch (Exception e) {
            ExceptionData.NOT_INTEGER.callErrorMessage();
        }
        validate(winningNumbers);
        return winningNumbers;
    }

    public int setBonusNumber(String rawNumber) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(rawNumber);
            return bonusNumber;
        } catch (Exception e) {
            ExceptionData.NOT_INTEGER.callErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != NumericData.NUMBER_AMOUNT.getNumericValue()) {
            ExceptionData.NOT_SIX_NUMBER.callErrorMessage();
            throw new IllegalArgumentException();
        }
        for (int number : winningNumbers) {
            validate(number);
        }
    }

    public void validate(int number) {
        if (number < NumericData.MIN_NUMBER.getNumericValue()
            || number > NumericData.MAX_NUMBER.getNumericValue()) {
            ExceptionData.NUMBER_RANGE.callErrorMessage();
            throw new IllegalArgumentException();
        }
    }
}
