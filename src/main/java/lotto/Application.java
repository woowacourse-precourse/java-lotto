package lotto;

public class Application {
    private static void CheckSmallMoney(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매가 가능합니다.");
        }
    }
    public static int BuyLotto(int money){
        CheckSmallMoney(money);
        int paper = money / 1000;
        System.out.println(paper);
        return paper;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
