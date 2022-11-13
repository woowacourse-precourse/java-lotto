package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UI {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String PRIZE_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    private final LottoLogic lottoLogic;

    public UI() {
        lottoLogic = new LottoLogic(moneyInput());
        printNumberOfLotto();
        printLottoNumber();
        setPrizeNumbers();
    }

    private int moneyInput() {
        System.out.println(MONEY_INPUT_MESSAGE);
        String moneyInput = Console.readLine();
        Validation.validateMoneyInput(moneyInput);

        return Integer.parseInt(moneyInput);
    }

    private void printNumberOfLotto() {
        System.out.println(this.lottoLogic.getNumberOfLotto() + PURCHASE_LOTTO_MESSAGE);
    }

    private void printLottoNumber() {
        for (int i = 0; i < this.lottoLogic.getBuyLottoList().size(); i++) {
            System.out.println(this.lottoLogic.getBuyLottoList().get(i).getNumbers());
        }
    }

    private void setPrizeNumbers() {
        System.out.println(PRIZE_INPUT_MESSAGE);
        String prizeNumberInput = Console.readLine();
        List<String> prizeNumbers = sliceInputNumber(prizeNumberInput);

        this.lottoLogic.setPrizeNumbers(stringListToIntegerList(prizeNumbers));
    }

    public List<String> sliceInputNumber(String value) {
        return List.of(value.split(","));
    }

    public List<Integer> stringListToIntegerList(List<String> stringList) {
        List<Integer> integerList = new ArrayList<>();
        for (String stringValue : stringList) {
            integerList.add(Integer.parseInt(stringValue));
        }
        return integerList;
    }
}