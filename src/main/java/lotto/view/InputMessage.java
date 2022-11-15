package lotto.view;


import java.util.List;
import java.util.stream.Collectors;

public class InputMessage {
    private final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요";
    private final String GAME_START = "게임 시작";
    private final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요";
    private final String NUMBER_PURCAHSES = "%d개를 구매했습니다.";
    private final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요";

    public void gameStart() {
        System.out.println(GAME_START);
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public Integer purchaseAmountMessage(int amount) {
        String format = String.format(NUMBER_PURCAHSES, amount / 1000);
        System.out.println(amount);
        System.out.println(format);
        return amount;
    }

    public List<List<Integer>> purchasedLottoNumberMessage(List<List<Integer>> lotts) {
        lotts.forEach(System.out::println);
        System.out.println(INPUT_WINNING_NUMBER);
        return lotts;
    }

    public List<Integer> winningNumberMessage(List<Integer> winningNumber) {
        String number = winningNumber.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(number);
        System.out.println(INPUT_BONUS_NUMBER);
        return winningNumber;
    }

    public int bonusNumberMessage(Integer bonusNumber) {
        System.out.println(bonusNumber);
        return bonusNumber;
    }

}
