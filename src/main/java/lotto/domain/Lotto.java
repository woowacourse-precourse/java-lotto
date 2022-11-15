package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public static List<Integer> winningNumbers(){
        System.out.println(Messages.INPUT_WINNING_NUMBERS);
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split("")){
            numbers.add(Integer.valueOf(number));
        }
        return numbers;
    }
    //검증하는 메서드
    private void validate(List<Integer> numbers) {
        try {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("6개의 숫자를 입력하세요.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("프로그램 종료!");
    }
}
