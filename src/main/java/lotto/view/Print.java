package lotto.view;

import java.util.List;

public class Print {
    private static final String USER_LOTTO_COUNT_MSG = "개를 구매했습니다.";
    private static final String GAME_START_MSG = "구입금액을 입력해 주세요.";
    private static final String COUNT = "개";
    private static final String THREE_LUCKY_MSG = "3개 일치 (5,000원) - ";
    private static final String FOUR_LUCKY_MSG = "4개 일치 (50,000원) - ";
    private static final String FIVE_LUCKY_MSG = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_BONUS_LUCKY_MSG = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_LUCKY_MSG = "6개 일치 (2,000,000,000원) - ";
    private static final String PLUS_MSG = "총 수익률은 ";
    private static final String PERCENT_MSG = "%입니다.";
    public static void viewAutoLotto(List<List<Integer>> numbers){
        for(int i=0;i<numbers.size();i++){
            System.out.println(numbers.get(i));
        }
    }
    public static void viewUserLottoCount(int lottoCount){
        System.out.println(lottoCount+USER_LOTTO_COUNT_MSG);
    }
    public static void viewGameStart(){
        System.out.println(GAME_START_MSG);
    }
    public static void viewPlusPercent(double plus){
        System.out.println(PLUS_MSG+Math.round(plus*100)/100.0+PERCENT_MSG);
    }
    public static void viewTotalLucky(int threeCount,int fourCount,int fiveCount,int bonusCount,int sixCount){
        System.out.println(THREE_LUCKY_MSG+threeCount+COUNT);
        System.out.println(FOUR_LUCKY_MSG+fourCount+COUNT);
        System.out.println(FIVE_LUCKY_MSG+fiveCount+COUNT);
        System.out.println(FIVE_BONUS_LUCKY_MSG+bonusCount+COUNT);
        System.out.println(SIX_LUCKY_MSG+sixCount+COUNT);
    }
}
