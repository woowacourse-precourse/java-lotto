package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.messages;

import java.util.*;

public class LottoIO {

    private List<Integer> lottoAnswer;
    private int bonus;

    public LottoIO() {
        lottoAnswer = new ArrayList<>();
    }

    // 당첨 번호 입력
    public void inputLottoAnswer() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        if (checkInvalidNumbers(input)) {
            throw new IllegalArgumentException(messages.INVALID_ANSWER.getErrorMsg());
        }
        System.out.println(input + "\n");
        String[] nums = input.split(",");
        for (String num : nums) {
            this.lottoAnswer.add(Integer.valueOf(num));
        }
    }

    // 보너스 번호 입력
    public void inputBonusAnswer() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        if (checkInvalidBonus(input, lottoAnswer)) {
            throw new IllegalArgumentException(messages.INVALID_BONUS.getErrorMsg());
        }
        System.out.println(input + "\n");
        Integer result = Integer.valueOf(input);
        this.bonus = result;
        return;
    }

    // 올바르지 않은 당첨 번호 확인
    public boolean checkInvalidNumbers(String input) {
        if (input == null) {
            return true;
        }
        String[] nums = input.split(",");
        if (checkInvalidLength(input, 6) || checkDuplicate(nums) || input.chars().filter(ch -> ch == ',').count() != 5) {
            return true;
        }
        for (String num : nums) {
            if (isNotNumericRange(num)) {
                return true;
            }
        }
        return false;
    }

    // 올바르지 않은 보너스 번호 확인
    public boolean checkInvalidBonus(String input, List<Integer> lottoAnswer) {
        if (input == null) {
            return true;
        }
        if (checkInvalidLength(input, 1) || isNotNumericRange(input)) {
            return true;
        }
        if (lottoAnswer.contains(Integer.valueOf(input))) {
            return true;
        }
        return false;
    }

    private boolean checkDuplicate(String[] input) {
        List<String> input1 = new ArrayList<>(List.of(input));
        Set<String> input2 = new HashSet<>(input1);

        if (input1.size() != input2.size()) {
            return true;
        }
        return false;
    }

    private boolean checkInvalidLength(String input, int cond) {
        String[] nums = input.split(",");
        if (nums.length != cond) {
            return true;
        }
        return false;
    }

    // 1~45 사이의 숫자 값인지 확인
    public boolean isNotNumericRange(String num) {
        if (!num.matches("[1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-5]")) {
            return true;
        }
        return false;
    }

    // 당첨 최종 결과 통계 출력
    public void printResult(List<Integer> counts, double yields) {
        printResultFormat();
        System.out.println("3개 일치 (5,000원) - " + counts.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + counts.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + counts.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + counts.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + counts.get(0) + "개");
        printYieldsFormat(yields);
    }

    public void printResultFormat() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    // 총 수익률 결과 출력
    public void printYieldsFormat(double yields) {
        System.out.print("총 수익률은 " + yields + "%입니다.");
    }

    public List<Integer> getLottoAnswer() {
        return this.lottoAnswer;
    }

    public void setLottoAnswer(List<Integer> lottoAnswer) {
        this.lottoAnswer = lottoAnswer;
    }

    public int getBonus() {
        return this.bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
