package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {
    public List<List<Integer>> lottoTickets;
    public int money;

    UserLotto(String input) {
        for (int i = 0; i <input.length() ; i++) {
            char letter = input.charAt(i);
            if (!(letter >= '0' && letter <= '9')) {
                throw new IllegalArgumentException("[ERROR] 올바른 금액을 입력하세요.");
            }
        }
        if (Integer.valueOf(input) % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 올바른 금액을 입력하세요.");
        }

        this.money = Integer.parseInt(input);
    }

    public static List<Integer> getLottoNumbers(String input) {
        String[] numberSplit = input.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        if (numberSplit.length > 6) {
            throw new IllegalArgumentException("[ERROR] 숫자를 정확히 입력해주세요");
        }
        for (int i = 0; i <6 ; i++) {
            int num = Integer.parseInt(numberSplit[i]);
            lottoNumbers.add(num);
        }
        return lottoNumbers;
    }
    public static List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void generateTickets() {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < money/1000; i++) {
            result.add(getLottoNumbers());
        }
        this.lottoTickets = result;
    }

}
