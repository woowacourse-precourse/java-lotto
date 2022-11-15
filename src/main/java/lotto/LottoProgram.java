package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

import static lotto.LottoConstants.*;

public class LottoProgram {
    private final String ASK_FOR_ORDER_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final String ORDER_QUANTITY_ALERT_MESSAGE = "%d개를 구매했습니다.\n";
    private final String ASK_FOR_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해주세요.";
    private final String ASK_FOR_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해주세요.";
    private final String WINNING_STATS_TITLE_MESSAGE = "당첨 통계\n---";
    private final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.\n";
    private final String _3_LOTTO_NUMBERS_MATCH_MESSAGE = "3개 일치 (5,000원) - %d개\n";
    private final String _4_LOTTO_NUMBERS_MATCH_MESSAGE = "4개 일치 (50,000원) - %d개\n";
    private final String _5_LOTTO_NUMBERS_MATCH_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
    private final String _5_LOTTO_NUMBERS_AND_BONUS_NUMBER_MATCH_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private final String _6_LOTTO_NUMBERS_MATCH_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";

    private LottoController lottoController;

    public LottoProgram(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    // 로또 프로그램 실행
    public void run() {
        LottoStats userLottoDetails = new LottoStats();
        List<Lotto> userLottos = createUserLottos();
        alertUserLottos(userLottos);
        WinningLotto winningLotto = createWinningLotto();

        showWinningStats(winningLotto, userLottos);
    }

    private void alertUserLottos(List<Lotto> userLottos) {
        for (Lotto userLotto : userLottos) {
            List<Integer> sortedNumbers = sortInAscending(userLotto.getNumbers());
            System.out.println(sortedNumbers);
        }
    }

    private List<Integer> sortInAscending(List<Integer> numbers) {
        List<Integer> numbersInArrayList = new ArrayList<>(numbers);
        Collections.sort(numbersInArrayList);
        return numbersInArrayList;
    }

    public List<Lotto> createUserLottos() {
        int orderPrice = getOrderPrice();
        int orderQuantity = lottoController.getOrderQuantity(orderPrice);
        alertOrderQuantity(orderQuantity);

        return lottoController.createLottos(orderQuantity);
    }

    private void alertOrderQuantity(int orderQuantity) {
        System.out.printf(ORDER_QUANTITY_ALERT_MESSAGE, orderQuantity);
    }

    private int getOrderPrice() {
        System.out.println(ASK_FOR_ORDER_PRICE_MESSAGE);
        Integer orderPrice = parseOrderPriceWithValidation(Console.readLine());
        if ((orderPrice % LOTTO_PRICE.getValue()) != 0) {
            String errorMessage = String.format("[ERROR] 로또는 %d원 단위로 구매할 수 있습니다.", LOTTO_PRICE.getValue());
            throw new IllegalArgumentException(errorMessage);
        }
        return orderPrice;
    }

    public WinningLotto createWinningLotto() {
        List<Integer> lottoNumbers = getLottoNumbers();
        int bonusNumber = getBonusNumber();
        validateDuplicates(lottoNumbers, bonusNumber);
        WinningLotto winningLotto = lottoController.createWinningLotto(lottoNumbers, bonusNumber);

        return winningLotto;
    }

    private List<Integer> getLottoNumbers() {
        System.out.println(ASK_FOR_LOTTO_NUMBERS_MESSAGE);
        List<Integer> lottoNumbers = new ArrayList<>();

        String[] splittedNumbers = Console.readLine().split(",");
        for (String splittedNumber : splittedNumbers) {
            Integer number = parseLottoNumberWithValidation(splittedNumber);
            validateNumberRange(number);
            lottoNumbers.add(number);
        }

        return lottoNumbers;
    }

    private int getBonusNumber() {
        System.out.println(ASK_FOR_BONUS_NUMBER_MESSAGE);
        return parseLottoNumberWithValidation(Console.readLine());
    }

    private void showWinningStats(WinningLotto winningLotto, List<Lotto> userLottos) {
        LottoStats lottoStats = lottoController.getLottoStats(winningLotto, userLottos);
        alertLottoStats(lottoStats);
        alertRateOfReturn(lottoStats.getRateOfReturn());
    }

    private void alertLottoStats(LottoStats lottoStats) {
        System.out.println(WINNING_STATS_TITLE_MESSAGE);
        System.out.printf(_3_LOTTO_NUMBERS_MATCH_MESSAGE, lottoStats.getCountOf3NumbersMatch());
        System.out.printf(_4_LOTTO_NUMBERS_MATCH_MESSAGE, lottoStats.getCountOf4NumbersMatch());
        System.out.printf(_5_LOTTO_NUMBERS_MATCH_MESSAGE, lottoStats.getCountOf5NumbersMatch());
        System.out.printf(
                _5_LOTTO_NUMBERS_AND_BONUS_NUMBER_MATCH_MESSAGE,
                lottoStats.getCountOf5NumbersAndBonusNumberMatch());
        System.out.printf(_6_LOTTO_NUMBERS_MATCH_MESSAGE, lottoStats.getCountOf6NumbersMatch());
    }


    private void alertRateOfReturn(Float rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }

    private Integer parseOrderPriceWithValidation(String orderPrice) {
        try {
            return Integer.parseInt(orderPrice);
        } catch (NumberFormatException e) {
            String errorMessage = String.format("[ERROR] 로또는 %d원 단위로 구매할 수 있습니다.", LOTTO_PRICE.getValue());
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private Integer parseLottoNumberWithValidation(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            String errorMessage = String.format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", LOTTO_START_NUMBER.getValue(), LOTTO_END_NUMBER.getValue());
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicates(List<Integer> numbers, int bonusNumber) {
        Set numberSet = new HashSet(numbers);
        numberSet.add(bonusNumber);

        if (numberSet.size() != (LOTTO_NUMBER_COUNT.getValue() + 1)) {
            String errorMessage = "[ERROR] 로또 번호는 중복되지 않는 6개의 숫자와 보너스 숫자 1개로 구성됩니다.";
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
