package lotto;

import java.util.List;

public class PrintUtil {

        public static void getLottos(int userLottoCnt) {
            System.out.println(userLottoCnt + "개를 구매했습니다.");
        }

        public static void userLottosPrint(List<Lotto> userLottos) {
            for(Lotto lotto : userLottos){
                System.out.print("[");
                userNumberPrint(lotto);
                System.out.print("]\n");
            }
        }

        private static void userNumberPrint(Lotto lotto) {
            for(int i = 0 ; i < lotto.getNumbers().size() ; i++){
                if(i == lotto.getNumbers().size() - 1){
                    System.out.print(lotto.getNumbers().get(i));
                    return;
                }
                System.out.print(lotto.getNumbers().get(i) + ", ");
            }
        }

    public static void inputWinNumberGuide() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void inputBonusNumberGuide() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
