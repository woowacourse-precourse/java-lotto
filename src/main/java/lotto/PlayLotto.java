package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayLotto {

    public void start() {
        Integer amount = getBuyAmount();
        Integer lottoTicketNumber = amount/Lotto.TICKET_PRICE;
        List<List<Integer>> lottos = Lotto.generateLotto(lottoTicketNumber);
        //로또 당첨 번호 입력 받기
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto firstPlace = new Lotto(inputConversion(Console.readLine()));
        Integer bonus = getBonusNumber();
        //보너스 번호 validity check
        firstPlace.validBonus(bonus);
        //places: [5등,4등,3등,2등,1등]
        List<Integer> places = firstPlace.countWins(lottos, bonus);
        firstPlace.printStats(places,amount);
    }

    public Integer getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonus;
        try {
            bonus = Integer.valueOf(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 보너스 번호는 Integer 이어야 합니다");
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 Integer 이어야 합니다");
        }
        return bonus;
    }
    public Integer getBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Integer amount;
        try {
            amount = Integer.valueOf(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자여야 합니다.");
        }
        Lotto.checkBuyAmount(amount);
        return amount;
    }
    public static List<Integer> inputConversion(String input) {
        String[] nums = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String num:nums) {
            try {
                numbers.add(Integer.parseInt(num));
            } catch (NumberFormatException e){
                throw new IllegalArgumentException("[ERROR] 로또 숫자는 Integer 이어야 합니다.");
            }
        }
        return numbers;
    }
}