package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumMap;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static final int lottoPrice = 1000;
    static final String lottoPriceString = addComma(lottoPrice);

    private static List<Integer> winningNumbers;
    private static Integer bonusNumber;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Lotto> lottos;
        EnumMap<WIN, Integer> winnings;

        try {
            int numOfLottos = howManyLotto();
            lottos = getRandomNLotto(numOfLottos);
            getWinningNumbers();
            getBonusNumber();
            winnings = checkWinnings(lottos);
            printStats(winnings, lottoPrice * numOfLottos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String addComma(int number) {
        final DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(number);
    }

    public static Integer readMoney() throws IllegalArgumentException {
        String userInput = Console.readLine();
        try {
            return Integer.valueOf(userInput);
        } catch (Exception e){
            throw new IllegalArgumentException(ERROR.PURCHASE_INPUT);
        }
    }

    public static void validateMoney(int money) throws IllegalArgumentException {
        if (money <= 0 || money % lottoPrice != 0) {
            throw new IllegalArgumentException(ERROR.PURCHASE_DIVIDE);
        }
    }

    public static void getWinningNumbers() throws IllegalArgumentException {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        winningNumbers = new ArrayList<>();
        String[] inputs = userInput.split(",");

        for (String input: inputs) {
            getWinningNumber(input);
        }
        validateWinning();
    }

    public static void getWinningNumber(String input) throws IllegalArgumentException {
        try{
            int number = Integer.parseInt(input);
            winningNumbers.add(number);
        }catch (Exception e){
            throw new IllegalArgumentException(ERROR.LOTTO_NUMBERS);
        }
    }

    public static void validateWinning(){
        Set<Integer> winnings = new HashSet<>(winningNumbers);

        if (winningNumbers.size() != 6 || winnings.size() != 6) {
            throw new IllegalArgumentException(ERROR.LOTTO_NUMBERS);
        }
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException(ERROR.LOTTO_NUMBERS);
            }
        }
    }

    public static void getBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine();

        try {
            bonusNumber = Integer.parseInt(userInput);
        } catch (Exception e){
            throw new IllegalArgumentException(ERROR.BONUS_NUMBER);
        }
        validateBonus();
    }

    public static void validateBonus(){
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR.BONUS_NUMBER);
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR.BONUS_NUMBER);
        }
    }

    public static Integer howManyLotto() {
        System.out.println("구입 금액을 입력해 주세요.");
        Integer money = readMoney();
        validateMoney(money);
        return Integer.valueOf(money/lottoPrice);
    }

    public static List<Lotto> getRandomNLotto(int n) {
        List<Integer> numbers;
        List<Lotto> lottos = new ArrayList<>();

        System.out.println(n + "개를 구매했습니다.");

        for (int i=0;i<n;i++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto newLotto = new Lotto(numbers);
            newLotto.printAscending();
            lottos.add(newLotto);
        }
        return lottos;
    }

    public static EnumMap<WIN, Integer> checkWinnings(List<Lotto> lottos) {
        int sameNumbers = 0;
        boolean sameBonus;
        EnumMap<WIN, Integer> winnings = new EnumMap<>(WIN.class);
        initiateWinnings(winnings);

        for (Lotto lotto : lottos) {
            sameNumbers = lotto.containsN(winningNumbers);
            sameBonus = lotto.contains(bonusNumber);
            WIN win = WIN.getWIN(sameNumbers, sameBonus);
            winnings.put(win, winnings.getOrDefault(win, 0) + 1);
        }
        return winnings;
    }

    public static void initiateWinnings (EnumMap<WIN, Integer> winnings) {
        List<WIN> wins = WIN.getAllWIN();
        for (WIN win : wins) {
            winnings.put(win, 0);
        }
    }

    public static void printStats(EnumMap<WIN, Integer> winnings, int inputMoney) {
        long totalMoney = 0L;
        System.out.println("당첨 통계");
        System.out.println("---");
        for (WIN win : winnings.keySet()) {
            if (win == WIN.WIN_NO) continue;
            totalMoney += printStatsOne(win, winnings.get(win));
        }
        printRateOfReturn(totalMoney, inputMoney);
    }

    public static Integer printStatsOne(WIN win, Integer k){
        int sameNumbers = win.getSameNumbers();
        int earnMoney = win.getMoney();
        String msg = sameNumbers + "개 일치";

        if (win == WIN.WIN_2ND) {
            msg += ", 보너스 볼 일치";
        }
        msg += " (" + addComma(earnMoney) + "원) - "+ k + "개";

        System.out.println(msg);
        return earnMoney * k;
    }

    public static void printRateOfReturn(Long totalMoney, int inputMoney) {
        float rateOfReturn = 100 * totalMoney / (float) inputMoney;
        String rate = String.format("%.1f", rateOfReturn);
        String rateUpper = addComma((int) Float.parseFloat(rate));
        rate = rate.substring(rate.length() - 2);
        System.out.println("총 수익률은 " + rateUpper + rate + "%입니다.");
    }

}
