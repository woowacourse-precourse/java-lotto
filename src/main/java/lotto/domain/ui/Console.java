package lotto.domain.ui;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Rank;
import lotto.domain.lotto.WinningNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Console {
    public int inputCellCount() {
        int amount = inputCellAmount();
        int count = calculateCount(amount);
        return count;
    }

    private int calculateCount(int amount) {
        if (amount % Lotto.PRICE != 0 || amount == 0) {
            throw new IllegalArgumentException("[ERROR] 1장에 " + Lotto.PRICE + "원 입니다. 딱 맞게 입력해 주세요.");
        }
        return amount / Lotto.PRICE;
    }

    private int inputCellAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String line = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println();
        int amount;
        try {
            amount = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 숫자를 입력해 주세요.");
        }
        return amount;
    }

    public WinningNumber inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto lottoNumber = inputLottoNumber();
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = inputBonusNumber();
        if (lottoNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR]: 중복 되는 번호 입니다.");
        }

        System.out.println();
        return new WinningNumber(lottoNumber, bonusNumber);
    }

    private int inputBonusNumber() {
        String line = camp.nextstep.edu.missionutils.Console.readLine();
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(line);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]: 정확한 숫자를 입력하세요.");
        }

        return bonusNumber;
    }

    private Lotto inputLottoNumber() {
        String line = camp.nextstep.edu.missionutils.Console.readLine();

        List<Integer> numbers = new ArrayList<>();
        for (String data : line.split(",")) {
            int number = Integer.parseInt(data);
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException("[ERROR]: 0 ~ 45 사이의 숫자를 입력해 주세요");
            }
            if (numbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR]: 중복 되지 않는 숫자를 입력하세요.");
            }
            numbers.add(number);
        }
        return new Lotto(numbers);
    }

    public void printResult(Map<Rank, Integer> rankings, double yieldRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(rankingInfo(Rank.FIFTH, rankings.get(Rank.FIFTH)));
        System.out.println(rankingInfo(Rank.FOURTH, rankings.get(Rank.FOURTH)));
        System.out.println(rankingInfo(Rank.THIRD, rankings.get(Rank.THIRD)));
        System.out.println(rankingInfo(Rank.SECOND, rankings.get(Rank.SECOND)));
        System.out.println(rankingInfo(Rank.FIRST, rankings.get(Rank.FIRST)));
        System.out.printf("총 수익률은 %.1f%%입니다.", yieldRate);
    }

    private String rankingInfo(Rank rank, int count) {
        return rank.getName() + " (" + convertAmountNotation(rank.getPrize()) + "원) - " + count + "개";
    }

    private String convertAmountNotation(long money) {
        return String.valueOf(money).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
    }

    public void printBuyLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }
}
