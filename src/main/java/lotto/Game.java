package wootech;

import java.util.List;

public class Game {
    static List<Integer> sixNumber;
    static int[] correct;
    static User user;
    static int money;
    static int bonus;
    private static double rateOfReturn;


    public Game(Lotto winningNumber, int bonus, User user, int money) {
        this.sixNumber = winningNumber.getNumbers();
        this.bonus = bonus;
        this.user = user;
        this.money = money;
        correct = new int[5];
        gameStart();
    }

    public static void gameStart() {
        correctCounting();
        printResult();
    }

    public static void printResult() {

        System.out.println("3개 일치 (5,000원) - " + correct[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + correct[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + correct[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + correct[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + correct[4] + "개");
        int[] prize = {5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000};
        double benefit = 0.0;
        for (int i = 0; i < correct.length; i++) {
            benefit += prize[i] * correct[i];
        }
        double result = benefit / money * 100;
        rateOfReturn = (Double.parseDouble(String.format("%.2f", result)));
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    public static int correctCounting() {
        Lotto[] userLottos = user.getLottos();
        int count = 0;
        for (int i = 0; i < userLottos.length; i++) {
            // 로또 번호에 포함 된것만 추려내서 카운트
            count = (int) userLottos[i].getNumbers().stream().filter(sixNumber::contains).count();

            boolean isCorrectBonus = userLottos[i].getNumbers().contains(bonus);
            addCountList(count, isCorrectBonus);
        }
        return count;
    }

    public static void addCountList(int count, boolean isCorrectBonus) {
        if (count == 3) {
            correct[0]++;
        }
        if (count == 4) {
            correct[1]++;
        }
        if (count == 5 && !isCorrectBonus) {
            correct[2]++;
        }
        if (count == 5 && isCorrectBonus) {
            correct[3]++;
        }
        if (count == 6) {
            correct[4]++;
        }

    }

}
