package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private static final String NUMERIC_PATTERN = "^\\d*$";
    private static final String SEPARATOR = ",";

    /**
     * 로또 게임을 진행하는 함수
     * 예외 발생 시 예외 메시지를 콘솔에 출력하고 종료
     *
     */
    public void play() {
        try {
            playCore();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /** 로또 게임을 실제로 진행하는 함수 */
    private void playCore() throws IllegalArgumentException {
        int buyPrice = receiveBuyPrice();
        int buyNum = buyPrice / Lotto.LOTTERY_PRICE;

        List<Lotto> lotteries = Lotto.generateLotteries(buyNum);

        printBuyResult(lotteries);

        List<Integer> winningNumbers = receiveWinningNumbers();
        int bonusNumbers = receiveBonusNumber();

        Map<LottoResult, Integer> result = compareLotteriesResult(lotteries, winningNumbers, bonusNumbers);

        printResult(buyPrice, result);
    }

    /**
     * 사용자로부터 로또의 구입금액을 입력받는 함수 <br/>
     *
     * @return 로또의 구입 금액
     */
    public Integer receiveBuyPrice() throws IllegalArgumentException {
        System.out.print("구입금액을 입력해 주세요. : ");
        String userInput = Console.readLine();

        return parseBuyPrice(userInput);
    }

    /**
     * 매개변수로 주어진 사용자의 입력을 파싱해 int로 구하는 함수 <br/>
     * 만약 구입 금액이 숫자가 아니거나 나누어 떨어지지 않는 경우 IllegalArgumentException 발생
     *
     * @param userInput 사용자의 입력 문자열
     * @return 로또 구입 금액
     */
    public int parseBuyPrice(String userInput) throws IllegalArgumentException {

        checkNumericPattern(userInput, "[ERROR] 구입 금액은 숫자로 입력해야 합니다.");

        int price = Integer.parseInt(userInput);

        checkBuyPriceUnit(price);

        return price;
    }

    /**
     * 구입 금액이 로또 가격으로 나누어 떨어지는지 검사하는 함수
     * 만약 나누어 떨어지지 않으면 IllegalArgumentException 발생
     * @param price 구입 금액
     */
    private void checkBuyPriceUnit(int price) throws IllegalArgumentException {
        if (price % Lotto.LOTTERY_PRICE != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] 구입 금액은 %d원 으로 나누어 떨어지는 값으로 입력해야 합니다.", Lotto.LOTTERY_PRICE));
        }
    }

    /**
     * 로또의 구입 갯수와 로또 번호들을 출력하는 함수
     *
     * @param lotteries 구입한 로또 정보
     */
    public void printBuyResult(List<Lotto> lotteries) {
        System.out.printf("\n%d개를 구매했습니다.\n", lotteries.size());
        for (Lotto lottery : lotteries) {
            System.out.println(lottery.toString());
        }
    }

    /**
     * 당첨 번호를 사용자로부터 입력받는 함수
     *
     * @return 당첨 번호 리스트
     */
    public List<Integer> receiveWinningNumbers() throws IllegalArgumentException {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();

        return parseWinningNumbers(userInput);
    }

    /**
     * 사용자로부터 입력받은 문자열을 Integer List로 파싱하는 함수
     *
     * @param userInput 사용자 입력
     * @return 당첨 번호 리스트
     */
    public List<Integer> parseWinningNumbers(String userInput) throws IllegalArgumentException {
        String[] splitedUserInputs = userInput.split(SEPARATOR);

        List<Integer> winningNumbers = new ArrayList<>();
        for (String splitedUserInput : splitedUserInputs) {
            checkNumericPattern(splitedUserInput, "[ERROR] 당첨 번호는 공백 없이 쉼표(,)로 구분된 숫자를 입력해야 합니다.");

            int number = Integer.parseInt(splitedUserInput);

            checkLotteryNumberRange(number);

            winningNumbers.add(number);
        }

        checkLotteryNumberLength(winningNumbers);

        return winningNumbers;
    }

    /**
     * 입력된 로또 당첨 숫자의 갯수가 로또의 숫자 갯수와 일치하는지 검사하는 함수
     * 만약 일치하지 않은경우 IllegalArgumentException 발생
     *
     * @param winningNumbers 파싱된 로또 당첨 번호
     */
    private void checkLotteryNumberLength(List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.size() != Lotto.LOTTERY_NUMBER_LENGTH) {
            throw new IllegalArgumentException(String.format("[ERROR] 당첨 결과는 %d개의 숫자로 구성되어야 합니다.", Lotto.LOTTERY_NUMBER_LENGTH));
        }
    }

    /**
     * 나눠진 사용자 입력이 숫자로만 구성되어있는지 확인하는 함수
     * 패턴에 일치하지 않는 경우 IllegalArgumentException 발생
     *
     * @param splitedUserInput ,로 나눠진 사용자 입력
     */
    private void checkNumericPattern(String splitedUserInput, String ExceptionMsg) throws IllegalArgumentException {
        if (!splitedUserInput.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMsg);
        }
    }

    /**
     * 로또 번호의 범위를 검사하는 함수
     * 범위를 벗어나는 경우 IllegalArgumentException 발생
     *
     * @param number 로또 번호
     */
    private void checkLotteryNumberRange(int number) throws IllegalArgumentException {
        boolean numberInRange = number <= Lotto.LOTTERY_END_NUMBER && number >= Lotto.LOTTERY_START_NUMBER;

        if (!numberInRange) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값 범위 입니다.");
        }
    }

    /**
     * 사용자로부터 보너스 번호를 입력받는 함수
     *
     * @return 보너스 번호
     */
    public int receiveBonusNumber() throws IllegalArgumentException {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine();

        checkNumericPattern(userInput, "[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
        int bonusNumber = Integer.parseInt(userInput);
        checkLotteryNumberRange(bonusNumber);

        return bonusNumber;
    }

    /**
     * 구입한 로또의 결과를 비교하는 함수
     *
     * @param lotteries      구입한 로또
     * @param winningNumbers 당첨 번호
     * @param bonus          보너스 번호
     * @return 결과를 Key로 가지고 당첨 횟수를 Value로 가지는 Map
     */
    public Map<LottoResult, Integer> compareLotteriesResult(List<Lotto> lotteries, List<Integer> winningNumbers, int bonus) {
        Map<LottoResult, Integer> compareResult = new HashMap<>();
        for (Lotto lottery : lotteries) {
            LottoResult result = lottery.compareWinningNumbers(winningNumbers, bonus);

            if (result == LottoResult.None) {
                continue;
            }

            int count = compareResult.getOrDefault(result, 0);
            compareResult.put(result, count + 1);
        }
        return compareResult;
    }

    /**
     * 로또의 최종 결과를 출력하는 함수
     *
     * @param buyPrice 구입 금액
     * @param result   당첨 결과
     */
    public void printResult(int buyPrice, Map<LottoResult, Integer> result) {
        System.out.println("\n당첨통계\n---");

        long amount = 0;
        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult == LottoResult.None) {
                continue;
            }

            int count = result.getOrDefault(lottoResult, 0);
            System.out.printf("%s - %d개\n", lottoResult.toString(), count);

            if (count > 0) {
                amount += lottoResult.getAmount() * count;
            }
        }
        double yield = ((double) amount / buyPrice) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }
}
