package lotto.view;

public class Print {
    final static String GET_USER_MONEY = "구입 금액을 입력해 주세요.";
    final static String WIN_NUMBERS = "당첨 번호를 입력해 주세요.";
    final static String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void requestMoneyMessage(){
        System.out.println(GET_USER_MONEY);
    }
    public static void requestWinNumbers(){
        System.out.println(WIN_NUMBERS);
    }
    public static void requestBonusNumber(){
        System.out.println(BONUS_NUMBER);
    }

    public static void howmanyLottos(int numberOfLottos){
        System.out.println(numberOfLottos + "개를 구매했습니다.");
    }


}
