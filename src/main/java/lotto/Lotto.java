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

    public static int[] castLotto(List<List<Integer>> lottoTickets, List<Integer> lottoNumbers, int bonusNumber){
        int[] result = new int[5];
        for (List<Integer> ticket: lottoTickets){
            ticket.retainAll(lottoNumbers);
            if (ticket.size() == 6){
                result[0]++;
            } else if (ticket.size() == 5 && lottoNumbers.contains(bonusNumber)) {
                result[1]++;
            } else if (ticket.size() == 5){
                result[2]++;
            } else  if (ticket.size() == 4){
                result[3]++;
            } else if (ticket.size() == 3){
                result[4]++;
            }
        }
        return result;
    }

    public static void printLotto(int[] result){
        System.out.println("3개 일치 (5,000원) - "+result[4]+"개");
        System.out.println("4개 일치 (50,000원) - "+result[3]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+result[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+result[1]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+result[0]+"개");
    }
    public static void printProfit(int[] result, int tickets) {
        int sum = 0;
        sum += result[0] * 2000000000;
        sum += result[1] * 30000000;
        sum += result[2] * 1500000;
        sum += result[3] * 50000;
        sum += result[4] * 5000;
        double profit = sum / (tickets*1000) * 100;
        String information = String.format("총 수익률은 %.2f입니다.", sum);
        System.out.println(information);
    }
    // TODO: 추가 기능 구현
}
