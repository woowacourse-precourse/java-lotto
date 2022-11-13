package lotto;

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
        System.out.println("3개 일치 (5,000원) - " + equalThree);
        System.out.println("4개 일치 (50,000원) - " + equalFour);
        System.out.println("5개 일치 (1,500,000원) - " + equalFive);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + equalFiveWithBonus);
        System.out.println("6개 일치 (2,000,000,000원) - " + equalSix);
    }
}
