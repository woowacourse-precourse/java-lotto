package lotto.domain;

public class Result {
    private static int equalThree = 0;
    private static int equalFour = 0;
    private static int equalFive = 0;
    private static int equalFiveWithBonus = 0;
    private static int equalSix = 0;

    public static void setEqualThree() {
        equalThree += 1;
    }

    public static void setEqualFour() {
        equalFour += 1;
    }

    public static void setEqualFive() {
        equalFive += 1;
    }

    public static void setEqualFiveWithBonus() {
        equalFiveWithBonus += 1;
    }

    public static void setEqualSix() {
        equalSix += 1;
    }

    public static void printResultElements() {
        System.out.println("3개 일치 (5,000원) - " + equalThree + "개");
        System.out.println("4개 일치 (50,000원) - " + equalFour + "개");
        System.out.println("5개 일치 (1,500,000원) - " + equalFive + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + equalFiveWithBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + equalSix + "개");
    }

    public static int calculateElements() {
        int money = 0;

        money += equalThree *  5000;
        money += equalFour * 50000;
        money += equalFive * 15000000;
        money += equalFiveWithBonus * 30000000;
        money += equalSix * 2000000000;

        return money;
    }
}
