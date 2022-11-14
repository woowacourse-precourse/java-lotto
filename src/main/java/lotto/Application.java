package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 금액 입력
        int count = money();
        List<List<Integer>> inputList = inputList(count);
        List<Integer> lottoList = lottoList();
        int bonusNum = bounsNum();

        System.out.println("\n당첨 통계\n---");
        int[] result = calculate(inputList, lottoList, bonusNum);
        output(result);
        revenue(result, count * 1000);
    }

    // 금액 입력
    private static int money() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("구입금액을 입력해 주세요.");
            int number = sc.nextInt();

            if (number % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1000단위로 입력해야 합니다.");
            }
            return number / 1000;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 정수로 입력해야 합니다.");
        }
    }

    // 금액에 맞는 수의 list출력
    private static List<List<Integer>> inputList(int count) {
        List<List<Integer>> list = new ArrayList<>();

        System.out.println("\n" + count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            List<Integer> lotto = randomList();
            list.add(lotto);
            System.out.println(lotto);
        }

        return list;
    }

    // 랜덤 로또번호 출력
    private static List<Integer> randomList() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        while (list.size() != 6) {
            int num = random.nextInt(45) + 1;
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        Collections.sort(list);
        return list;
    }

    // 당첨번호 압력
    private static List<Integer> lottoList() {
        try {
            List<Integer> list = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String lottoString = sc.nextLine();

            // list로 변환
            for (int i = 0; i < lottoString.split(",").length; i++) {
                String unit = lottoString.split(",")[i];
                list.add(Integer.parseInt(unit));
            }
            // validate
            Lotto lotto = new Lotto(list);

            return list;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 입력값의 범위를 지켜야합니다.");
        }
    }

    // 보너스번호
    private static int bounsNum() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n보너스번호를 입력해 주세요.");
            int bonus = sc.nextInt();
            // validate
            if (bonus > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스번호는 46보다 작아야합니다.");
            } else if (bonus < 1) {
                throw new IllegalArgumentException("[ERROR] 보너스번호는 0보다 커야합니다.");
            }

            return bonus;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 보너스번호는 숫자여야합니다.");
        }
    }

    // 통계 계산
    private static int[] calculate(List<List<Integer>> inputList, List<Integer> lottoList, int bonus) {
        int[] arr = { 0, 0, 0, 0, 0 };
        for (int i = 0; i < inputList.size(); i++) {
            if (check(inputList.get(i), lottoList, bonus).equals("1등")) {
                arr[0]++;
            } else if (check(inputList.get(i), lottoList, bonus).equals("2등")) {
                arr[1]++;
            } else if (check(inputList.get(i), lottoList, bonus).equals("3등")) {
                arr[2]++;
            } else if (check(inputList.get(i), lottoList, bonus).equals("4등")) {
                arr[3]++;
            } else if (check(inputList.get(i), lottoList, bonus).equals("5등")) {
                arr[4]++;
            }
        }

        return arr;
    }

    // 포함여부
    private static String check(List<Integer> inputList, List<Integer> lottoList, int bonus) {
        int match = 0;
        int match_bonus = 0;
        for (int i = 0; i < inputList.size(); i++) {
            if (lottoList.contains(inputList.get(i))) {
                match++;
            }
            if (lottoList.contains(bonus)) {
                match_bonus++;
            }
        }

        return rank(match, match_bonus);
    }

    // 등수 출력
    private static String rank(int match, int match_bonus) {
        if (match == 3) {
            return "5등";
        } else if (match == 4) {
            return "4등";
        } else if (match == 5 && match_bonus == 1) {
            return "2등";
        } else if (match == 5) {
            return "3등";
        } else if (match == 6) {
            return "1등";
        }
        return "없음";
    }

    // 결과 출력
    private static void output(int[] arr) {
        System.out.println("3개 일치 (5,000원) - " + arr[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + arr[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + arr[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + arr[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + arr[0] + "개");
    }

    // 수익율
    private static double revenue(int[] arr, int money) {
        double reward = 0;
        reward += 5000 * arr[4];
        reward += 50000 * arr[3];
        reward += 1500000 * arr[2];
        reward += 30000000 * arr[1];
        reward += 2000000000 * arr[0];
        reward /= money;

        System.out.println("총 수익률은 " + Math.round(reward * 100) / 100.0 + "%입니다.");

        return reward;
    }
}
