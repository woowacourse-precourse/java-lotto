package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    // 로또 당첨 번호 입력
    public List<Integer> createLuckyNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String numberLine = Console.readLine();
        List<Integer> luckyNumbers = validateNumberLine(numberLine);
        validateLuckyNumber(luckyNumbers);

        return luckyNumbers;
    }

    // 로또 보너스 번호 입력
    public int createBonusNumber(List<Integer> luckyNumbers) {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int number = Integer.parseInt(Console.readLine());
        validateNumber(number);
        validateBonusOverlap(luckyNumbers, number);
        return number;
    }

    // 로또 당첨 번호 입력 방식 확인
    private List<Integer> validateNumberLine(String numberLine) {
        List<Integer> luckyNumbers;
        try {
            luckyNumbers = Arrays.asList(numberLine.split(","))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.ERROR_WRONG_INPUT.getMessage());
        }
        return luckyNumbers;
    }


    // 로또 당첨 번호 전체 확인 과정
    private void validateLuckyNumber(List<Integer> luckyNumbers) {
        validateLuckyNumberSize(luckyNumbers, 6);
        validateLuckyNumberOverlap(luckyNumbers);
        for (int i = 0; i < luckyNumbers.size(); i++) {
            validateNumber(luckyNumbers.get(i));
        }
    }

    // 당첨 번호 개수 확인
    private void validateLuckyNumberSize(List<Integer> numbers, int size) {
        if (numbers.size() != size) {
            throw new IllegalArgumentException(Error.ERROR_WRONG_SIZE.getMessage());
        }
    }

    // 당첨 번호 중복 확인
    private void validateLuckyNumberOverlap(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(Error.ERROR_OVERLAP_NUMBER.getMessage());
        }
    }

    // 보너스 번호 중복 확인
    private void validateBonusOverlap(List<Integer> luckyNumbers, int bonusNumber) {
        if (luckyNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Error.ERROR_OVERLAP_NUMBER.getMessage());
        }
    }

    // 번호 숫자 범위 확인
    private void validateNumber(int number) {
        if (number < 1 && number > 45) {
            throw new IllegalArgumentException(Error.ERROR_WRONG_NUMBER.getMessage());
        }
    }


}
