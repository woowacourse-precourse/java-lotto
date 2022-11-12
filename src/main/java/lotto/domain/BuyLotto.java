package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BuyLotto {
    public enum INPUT_SENTENCE {
        BUY("구입금액을 입력해 주세요.\n"), RESULT_COUNT("개를 구매했습니다.\n"), WIN("당첨 번호를 입력해 주세요.\n"),;

        private final String label;

        INPUT_SENTENCE(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }
    }
    private static final String WRONG_NUMBER_ERROR = "[ERROR] 올바른 숫자를 입력해 주세요.";

    int userPrice = 0;
    public void userPriceInput() {
        try {
            System.out.print(INPUT_SENTENCE.BUY.label());
            String userPrice = Console.readLine();
            validateUserPrice(userPrice);
            this.userPrice = Integer.parseInt(userPrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static void validateUserPrice(String userPrice) throws IllegalArgumentException {
        boolean isNumeric = userPrice.chars().allMatch( Character::isDigit );
        if (userPrice.charAt(userPrice.length()-1) != '0' || userPrice.charAt(userPrice.length()-2) != '0' || userPrice.charAt(userPrice.length()-3) != '0'
                ||isNumeric != true) {
            throw new IllegalArgumentException(WRONG_NUMBER_ERROR);
        }
    }

    private int buyLottoCount() {
        userPriceInput();
        int userPrice = this.userPrice;
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
        System.out.println();
        return lottoNumbers;
    }

    public List<Integer> numbers() {
        System.out.print(INPUT_SENTENCE.WIN.label());
        String number = Console.readLine();
        List<String> winNumbers = new ArrayList<>(Arrays.asList(number.split("\\s*,\\s*")));
        List<Integer> winNumber = new ArrayList<>();
        for(int i = 0; i<winNumbers.size(); i++) {
            winNumber.add(Integer.parseInt(winNumbers.get(i)));
        }
        return winNumber;
    }
}
