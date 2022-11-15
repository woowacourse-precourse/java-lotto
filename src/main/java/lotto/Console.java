package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Console {
    private static final String ERROR_MESSAGE = "[ERROR]";
    public double inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        double money = 0;
        try {
            money = Double.valueOf(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return money;
    }
    public Lotto inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] line = readLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            numbers.add(Integer.parseInt(line[i]));
        }
        return new Lotto(numbers);
    }
    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(readLine());
    }
    public void outputMyLottos(List<Integer>[] numbers) {
        int count = numbers.length;
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            System.out.println(numbers[i]);
        }
    }
    public void outputWinningResult(Map<Rank, Integer> result, double yield) {
        System.out.println("당첨 통계\n---");
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        for (Rank value : Rank.values()) {
            String splitCommaMoney = decimalFormat.format(value.money);
            int count = result.getOrDefault(value, 0);
            System.out.println(sumRankMessage(value, splitCommaMoney, count));
        }
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
    private String sumRankMessage(Rank rank, String splitCommaMoney, int count) {
        if (rank == Rank.SECOND) {
            return rank.correctCount + "개 일치, 보너스 볼 일치 (" + splitCommaMoney + "원) - " + count + "개";
        }
        return rank.correctCount + "개 일치 (" + splitCommaMoney + "원) - " + count + "개";
    }
    public void outputErrorMessage() {
        System.out.println(ERROR_MESSAGE + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    public void outputMoneyErrorMessage() {
        System.out.println(ERROR_MESSAGE + " 구입 금액은 1,000원 단위로 입력하셔야 합니다.");
    }
}
