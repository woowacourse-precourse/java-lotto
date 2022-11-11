package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static int getMoney(String input) {
        int money = Integer.valueOf(input);
        if (money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 금액을 올바르게 넣어주세요!");
        }
        int tickets = Integer.valueOf(input) / 1000;
        return tickets;
    }

    public static List<List<Integer>> generateNumbers(int tickets){
        List<List<Integer>> lottoTickets = new ArrayList<>();
        return lottoTickets;
    }

    public static void printNumbers(List<List<Integer>> lottoTickets, int tickets){
        System.out.println();
    }

    public static List<Integer> getNumbers(String input){
        List<Integer> lottoNumbers = new ArrayList<>();

        return  lottoNumbers;
    }

    public static int getBonusNumber(String input){
        int bonusNumber = Integer.valueOf(input);
        return  bonusNumber;
    }

    public static int castLotto(List<List<Integer>> lottoTickets, List<Integer> lottoNumbers, int bonusNumber){
        int result = 0;
        System.out.println();
        return result;
    }

    public static void printLotto(){
        System.out.println();
    }
    public static void printProfit() {
        System.out.println();
    }
    // TODO: 추가 기능 구현
}
