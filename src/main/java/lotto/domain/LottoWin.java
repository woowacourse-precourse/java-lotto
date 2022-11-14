package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWin {

    // 로또 당첨 번호 입력
    public List<Integer> createLuckyNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numberLine = Console.readLine();
        List<Integer> luckyNumbers = validateNumberLine(numberLine);
        validateLuckyNumber(luckyNumbers);

        return luckyNumbers;
    }

    // 로또 보너스 번호 입력
    public int createBonusNumber(List<Integer> luckyNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int number = Integer.parseInt(Console.readLine());
        validateNumber(number);
        validateBonusOverlap(luckyNumbers, number);
        return number;
    }

    private List<Integer> validateNumberLine(String numberLine){
        List<Integer> luckyNumbers;
        try{
            luckyNumbers = Arrays.asList(numberLine.split(","))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력 방식이 잘못되었습니다.");
        }

        return luckyNumbers;
    }


    // 로또 당첨 번호 예외처리
    private void validateLuckyNumber(List<Integer> luckyNumbers) {
        validateLuckyNumberSize(luckyNumbers, 6);
        validateLuckyNumberOverlap(luckyNumbers);
        for (int i = 0; i < luckyNumbers.size(); i++) {
            validateNumber(luckyNumbers.get(i));
        }
    }

    // 당첨 번호 개수 확인 및 예외 처리
    private void validateLuckyNumberSize(List<Integer> numbers, int size){
        if(numbers.size() != size){
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수가 잘못되었습니다.");
        }
    }

    // 당첨 번호 중복 확인 및 예외 처리
    private void validateLuckyNumberOverlap(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 당첨 번호 중 중복되는 번호가 있습니다.");
        }
    }
    
    private void validateBonusOverlap(List<Integer> luckyNumbers, int bonusNumber){
        if(luckyNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    // 번호별 범위 확인 및 예외 처리
    private void validateNumber(int number) {
        if (number < 1 && number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }


}
