package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

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

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        int money = Integer.valueOf(input);
        if (money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 금액을 올바르게 넣어주세요!");
        }
        int tickets = Integer.valueOf(input) / 1000;
        return tickets;
    }

    public static List<List<Integer>> generateNumbers(int tickets){
        List<List<Integer>> lottoTickets = new ArrayList<>();
        for (int i=0; i<tickets; i++){
            List<Integer> ticketNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Set<Integer> set = new HashSet<Integer>(ticketNumbers);
            while (set.size() < ticketNumbers.size()){
                ticketNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                set = new HashSet<Integer>(ticketNumbers);
            }
            lottoTickets.add(ticketNumbers);
        }
        return lottoTickets;
    }

    public static void printNumbers(List<List<Integer>> lottoTickets, int tickets){
        System.out.println(tickets+"개를 구매했습니다.");
        for (int i=0; i<lottoTickets.size(); i++){
            System.out.println(lottoTickets.get(i));
        }
    }

    public static List<Integer> getNumbers(){
        List<Integer> lottoNumbers = new ArrayList<>();
        String input = readLine();
        if (input.length() > 11){
            throw new IllegalArgumentException("[ERROR] 숫자를 정확히 입력해주세요");
        }
        List<String> inputNumbers = Arrays.asList(input.split(","));
        if(inputNumbers.size() != inputNumbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자를 입력해주세요");
        }
        for (String number: inputNumbers){
            lottoNumbers.add(Integer.parseInt(number));
        }
        Collections.sort(lottoNumbers);
        return  lottoNumbers;
    }

    public static int getBonusNumber(){
        String input = readLine();
        String regex = "\\d+";

        if (input.length() > 1){
            throw new IllegalArgumentException("[ERROR] 한 자리 숫자만 입력해주세요");
        }
        if (!input.matches(regex)){
            throw new IllegalArgumentException("[ERROR] 한 자리 숫자만 입력해주세요");
        }
        int bonusNumber = Integer.valueOf(input);
        return bonusNumber;
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
