package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.EnumMap;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static final int lottoPrice = 1000;
    private static final String lottoPriceString = addComma(lottoPrice);
    private static final String errorMsg1 = "[ERROR] 구입금액은 숫자를 입력해야 합니다.";
    private static final String errorMsg2 =
            "[ERROR] 구입 금액은 " + lottoPriceString + "원으로 나누어 떨어지는 자연수여야 합니다.";
    private static final String errorMsg3 =
            "[ERROR] 로또 번호는 1 ~ 45 사이의 중복되지 않는 6자리 자연수여야 합니다.";
    private static final String errorMsg4 =
            "[ERROR] 보너스 번호는 1 ~ 45 사이의 로또 번호와 중복되지 않는 1자리 자연수여야 합니다.";

    private static List<Integer> winningNumbers;
    private static Integer bonusNumber;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int numOfLottos = howManyLotto();
        int totalMoney = lottoPrice * numOfLottos;
        List<Lotto> lottos;
        EnumMap<WIN, Integer> winnings;

        lottos = getRandomNLotto(numOfLottos);
        getWinningNumbers();
        getBonusNumber();

        winnings = checkWinnings(lottos);

        printStats(winnings, totalMoney);

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
            throw new IllegalArgumentException(errorMsg1);
        }
    }

    public static void validateMoney(int money) throws IllegalArgumentException {
        if (money <= 0 || money % lottoPrice != 0) {
            throw new IllegalArgumentException(errorMsg2);
        }
    }

    public static void getWinningNumbers() throws IllegalArgumentException {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        winningNumbers = new ArrayList<>();
        String[] inputs = userInput.split(",");

        for (String input: inputs) {
            try{
                int number = Integer.parseInt(input);
                winningNumbers.add(number);
            }catch (Exception e){
                throw new IllegalArgumentException(errorMsg3);
            }
        }
        validateWinning();
    }

    public static void validateWinning(){
        Set<Integer> winnings = new HashSet<>(winningNumbers);

        if (winningNumbers.size() != 6 || winnings.size() != 6) {
            throw new IllegalArgumentException(errorMsg3);
        }
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException(errorMsg3);
            }
        }
    }

    public static void getBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine();

        try {
            bonusNumber = Integer.parseInt(userInput);
        } catch (Exception e){
            throw new IllegalArgumentException(errorMsg4);
        }
        validateBonus();
    }

    public static void validateBonus(){
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(errorMsg4);
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(errorMsg4);
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
        WIN win;

        for (Lotto lotto : lottos) {
            sameNumbers = lotto.containsN(winningNumbers);
            sameBonus = lotto.contains(bonusNumber);
            win = WIN.getWIN(sameNumbers, sameBonus);
            winnings.put(win, winnings.getOrDefault(win, 0));
        }
        return winnings;
    }

    public static void printStats(EnumMap<WIN, Integer> winnings, int inputMoney) {
        long totalMoney = 0L;
        System.out.println("당첨 통계");
        System.out.println("---");
        for (WIN win : winnings.keySet()) {
            if (win == WIN.WIN_NO)
                continue;
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
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

}
