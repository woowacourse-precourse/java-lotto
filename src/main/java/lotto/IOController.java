package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class IOController {

    public static int readBuyingMoney() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int buyingMoney;
        try { buyingMoney = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 구입 금액은 숫자입니다.");
        }
        if(buyingMoney < 0 || buyingMoney > MoneyConstant.MAX_LOTTO_PRIC.getValue()){
            throw new IllegalArgumentException("로또 구입 금액은 0원이상 2,000,000,000원 이하입니다.");
        }
        if (buyingMoney % 1000 != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원 단위입니다.");
        }
        return buyingMoney / 1000;
    }

    public static List<Integer> readWinningNumbers() throws IllegalArgumentException {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String pattern = "^([1-9]?[0-9],){5}[1-9]?[0-9]$";
        if (!Pattern.matches(pattern, input)) {
            throw new IllegalArgumentException("쉼표로 구분된 6개의 숫자를 입력해야 합니다.");
        }
        String[] splitedInputs = input.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String splitedInput : splitedInputs) {
            int lottoNumber = Integer.parseInt(splitedInput);
            validateNumberRange(lottoNumber);
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    public static int readBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        String pattern = "^[1-9]?[0-9]$";
        if (!Pattern.matches(pattern, input)) {
            throw new IllegalArgumentException("최대 두자리 숫자를 입력해야 합니다.");
        }
        validateNumberRange(Integer.parseInt(input));
        return Integer.parseInt(input);
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printPrizeResult(List<Integer> allRankings, Integer buyingLottoNumber) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + allRankings.get(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + allRankings.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + allRankings.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + allRankings.get(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + allRankings.get(1) + "개");
        LottoService lottoService = new LottoService();
        Float earningRate = lottoService.calculateEarningRate(allRankings, buyingLottoNumber);
        System.out.println("총 수익률은 " + String.format("%.1f", earningRate) + "%입니다.");
    }

    public static void printExceptionMessage(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }


    private static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
