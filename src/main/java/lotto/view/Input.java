package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public int getMoney(){
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String unverifiedCharacters = Console.readLine();
            int money = Integer.parseInt(unverifiedCharacters);
            if(money < 1000) validationMoney();
            if(money % 1000 != 0) validationDivideMoney();
            return money;
        }catch (IllegalArgumentException e){
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return getMoney();
        }
    }

    public Lotto getWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");

        String winningNumbers = Console.readLine();

        String[] numbers = winningNumbers.split(",");
        try {
            List<String> winningNumbersCast =
                    Arrays.stream(numbers)
                            .map(String::trim)
                            .collect(Collectors.toList());
            return convertLettersToNumbers(winningNumbersCast);
        }catch (IllegalArgumentException e){
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return getWinningNumbers();
        }
    }

    private Lotto convertLettersToNumbers(List<String> stringWinningAmount) {
        try {
            List<Integer> winningNumbers = new ArrayList<>();
            for(String number : stringWinningAmount){
                winningNumbers.add(Integer.parseInt(number));
            }
            isItInRange(winningNumbers);
            return new Lotto(winningNumbers);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private void isItInRange(List<Integer> winningNumbers) {
        try {
            int count = (int) winningNumbers.stream().
                    filter(num -> num >= 1 && num <= 45).distinct()
                    .count();
            if(count != 6) {
                throw new IllegalArgumentException("범위 밖의 숫자 또는 중복된 숫자를 입력하셨습니다.");
            }
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validationDivideMoney() {
        throw new IllegalArgumentException("1000으로 나누어 떨어지는 금액을 입력해주세요.");
    }

    private void validationMoney() {
        throw new IllegalArgumentException("1000원 이상의 금액을 입력해주세요.");
    }
}
