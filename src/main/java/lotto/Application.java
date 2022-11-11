package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {

    private static final int LOTTERY_PRICE = 1000;
    private static final String NUMERIC_PATTERN = "^\\d*$";
    private static final String SEPARATOR = ",";

    public static void main(String[] args) {

        try {
            int buyPrice = receiveBuyPrice();
            int buyNum = buyPrice / LOTTERY_PRICE;

            List<Lotto> lotteries = Lotto.generateLotteries(buyNum);

            printBuyResult(lotteries);

            List<Integer> winningNumbers = receiveWinningNumbers();
            int bonusNumbers = receiveBonusNumber();

            Map<LottoResult, Integer> result = compareLotteriesResult(lotteries, winningNumbers, bonusNumbers);

            printResult(buyPrice, result);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * 사용자로부터 로또의 구입금액을 입력받는 함수 <br/>
     *
     * @return 로또의 구입 금액
     */
    public static Integer receiveBuyPrice() throws IllegalArgumentException {
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
    public static int parseBuyPrice(String userInput) throws IllegalArgumentException {

        if (!userInput.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
        }

        int price = Integer.parseInt(userInput);

        if (price % LOTTERY_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원으로 나누어 떨어지는 값으로 입력해야 합니다.");
        }

        return price;
    }

    /**
     * 로또의 구입 갯수와 로또 번호들을 출력하는 함수
     *
     * @param lotteries 구입한 로또 정보
     */
    public static void printBuyResult(List<Lotto> lotteries) {
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
    public static List<Integer> receiveWinningNumbers() throws IllegalArgumentException {
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
    public static List<Integer> parseWinningNumbers(String userInput) throws IllegalArgumentException {
        String[] splitedUserInputs = userInput.split(SEPARATOR);

        List<Integer> winningNumbers = new ArrayList<>();
        for (String splitedUserInput : splitedUserInputs) {
            if (!splitedUserInput.matches(NUMERIC_PATTERN))
                throw new IllegalArgumentException("[ERROR] 당첨 결과는 공백없이 쉼표를 기준으로 입력해야합니다.");

            int number = Integer.parseInt(splitedUserInput);
            winningNumbers.add(number);
        }

        if (winningNumbers.size() != Lotto.LOTTERY_NUMBER_LENGTH)
            throw new IllegalArgumentException(String.format("[ERROR] 당첨 결과는 %d개의 숫자로 구성되어야 합니다.", Lotto.LOTTERY_NUMBER_LENGTH));

        return winningNumbers;
    }

    /**
     * 사용자로부터 보너스 번호를 입력받는 함수
     *
     * @return 보너스 번호
     */
    public static int receiveBonusNumber() throws IllegalArgumentException {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine();

        if (!userInput.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로만 입력해야 합니다.");
        }

        return Integer.parseInt(userInput);
    }

    /**
     * 구입한 로또의 결과를 비교하는 함수
     *
     * @param lotteries      구입한 로또
     * @param winningNumbers 당첨 번호
     * @param bonus          보너스 번호
     * @return 결과를 Key로 가지고 당첨 횟수를 Value로 가지는 Map
     */
    public static Map<LottoResult, Integer> compareLotteriesResult(List<Lotto> lotteries, List<Integer> winningNumbers, int bonus) {
        Map<LottoResult, Integer> compareResult = new HashMap<>();
        for (Lotto lottery : lotteries) {
            LottoResult result = lottery.compareWinningNumbers(winningNumbers, bonus);

            if (result == LottoResult.None) continue;

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
    public static void printResult(int buyPrice, Map<LottoResult, Integer> result) {
        System.out.println("\n당첨통계\n---");

        long amount = 0;
        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult == LottoResult.None) continue;

            int count = result.getOrDefault(lottoResult, 0);
            System.out.printf("%s - %d개\n", lottoResult.toString(), count);

            if (count > 0) amount += lottoResult.getAmount() * count;
        }
        double yield = ((double) amount / buyPrice) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }


}
