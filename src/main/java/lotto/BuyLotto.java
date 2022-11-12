package lotto;

import camp.nextstep.edu.missionutils.Console;

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

    public void buyLottoCount() {
        int userPrice = userPriceInput();
        int lottoCount = userPrice / 1000;
        System.out.println("\n"+lottoCount+INPUT_SENTENCE.RESULT_COUNT.label());
    }

}
