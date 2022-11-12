package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyLotto {
    public enum INPUT_SENTENCE {
        BUY("구입금액을 입력해 주세요.\n"), RESULT_COUNT("개를 구매했습니다.\n");

        private final String label;

        INPUT_SENTENCE(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }
    }

    private int userPriceInput() {
        System.out.print(INPUT_SENTENCE.BUY.label());
        String userPrice = Console.readLine();
        if (userPrice.charAt(userPrice.length()-1) != '0' || userPrice.charAt(userPrice.length()-2) != '0' || userPrice.charAt(userPrice.length()-3) != '0') {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해 주세요.");
        }
        return Integer.parseInt(userPrice);
    }

    private int buyLottoCount() {
        int userPrice = userPriceInput();
        int lottoCount = userPrice / 1000;
        System.out.print("\n"+lottoCount+INPUT_SENTENCE.RESULT_COUNT.label());
        return lottoCount;
    }

    public List<List<Integer>> lottoNumberMaker() {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        int lottoCount = buyLottoCount();
        for(int i=0; i<lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            System.out.println(numbers);
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }

}
