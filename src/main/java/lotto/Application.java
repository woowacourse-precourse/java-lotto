package lotto;


import static lotto.StartLotto.startLotto;

public class Application {
    public static void main(String[] args) {
        try {
            startLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }


/*
    public static void PrintEnd(int first, int second, int third, int fourth, int fifth, int money) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000)원 - " + fifth + "개");
        System.out.println("4개 일치 (50,000)원 - " + fourth + "개");
        System.out.println("5개 일치 (1,500,000)원 - " + third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000)원 - " + second + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + first + "개");
        int total = fifth * 5000 + fourth * 50000 + third * 1500000 + second * 30000000 + first * 2000000000;
        float rev = total / money;
        System.out.println("총 수익률은 " + Math.round(rev * 10) / 10.0 + "입니다.");
    }
*/
}
