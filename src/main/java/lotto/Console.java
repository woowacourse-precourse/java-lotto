package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Console {
    private static final String ERROR_MESSAGE = "[ERROR]";
    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(readLine());
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
            System.out.println(value.correctCount + "개 일치 (" + splitCommaMoney + "원) - " +
                    result.getOrDefault(value, 0) + "개");
        }
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
    public void outputErrorMessage() {
        System.out.println(ERROR_MESSAGE + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
