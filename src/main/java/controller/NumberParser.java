package controller;

import data.NumericData;
import java.util.List;
import java.util.ArrayList;

public class NumberParser {


    /**
     * NumberParserTest.java 테스트용 생성자
     * @param winningNumbers 당첨 번호 리스트
     */
    public NumberParser(List<Integer> winningNumbers) {
        validate(winningNumbers);
    }

    /**
     * NumberParserTest.java 테스트용 생성자
     * @param number 보너스 번호
     */
    public NumberParser(int number){
        validate(number);
    }

    public NumberParser() { }

    public List<Integer> setWinningNumbers(String rawNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] splittedNumbers = rawNumbers.split(",");
        try {
            for (String number : splittedNumbers) {
                winningNumbers.add(Integer.parseInt(number));
            }
            validate(winningNumbers);
            return winningNumbers;
        }catch(Exception e){
            System.out.println("임시 에러: 숫자를 입력해야 한다.");
            throw new IllegalArgumentException();
        }
    }

    public int setBonusNumber(String rawNumber){
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(rawNumber);
            return bonusNumber;
        } catch(Exception e) {
            System.out.print("임시 에러: 숫자를 입력해야 한다.");
            throw new IllegalArgumentException();
        }
    }

    public void validate(List<Integer> winningNumbers) {
        if(winningNumbers.size() != NumericData.NUMBER_AMOUNT.getNumericValue()){
            System.out.println("임시에러: 숫자 6개만 넣어야한다.");
            throw new IllegalArgumentException();
        }
        for(int number : winningNumbers) {
            validate(number);
        }
    }

    public void validate(int number) {
        if(number < NumericData.MIN_NUMBER.getNumericValue()
            || number > NumericData.MAX_NUMBER.getNumericValue()){
            System.out.println("임시에러: 1부터 45사이의 숫자여야한다.");
            throw new IllegalArgumentException();
        }
    }
}
