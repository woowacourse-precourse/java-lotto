package View;

import Domain.Lotto;
import Domain.LottoList;

public class OutputView {
    private static final String PRINT_NUMBER_OF_LOTTO_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String PRINT_EACH_LOTTO_NUMBER_START = "[";
    private static final String PRINT_EACH_LOTTO_NUMBER_END = "]";
    private static final String PRINT_EACH_LOTTO_NUMBER_SEPARATOR = ", ";
    public static void printNumberOfLotto(LottoList lottoList){
        System.out.printf(PRINT_NUMBER_OF_LOTTO_MESSAGE, lottoList.getAvailableLottoPlayNumber());
        printEachLottoNumber(lottoList);
    }

    public static void printEachLottoNumber(LottoList lottoList){
        for(Lotto lotto : lottoList.getLottoList()){
            System.out.print(PRINT_EACH_LOTTO_NUMBER_START); //상수
            int lottoLength = lotto.getLottoNumbers().size();
            for(int i=0; i<lottoLength-1; i++){
                System.out.print(lotto.getLottoNumbers().get(i) + PRINT_EACH_LOTTO_NUMBER_SEPARATOR); //상수
            }
            System.out.print(lotto.getLottoNumbers().get(lottoLength-1));
            System.out.println(PRINT_EACH_LOTTO_NUMBER_END); //상수
        }
        System.out.println();
    }

    public static void printLottoResult(int[] countList, LottoList lottoList, int myReward){ //상수
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + countList[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + countList[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countList[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countList[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countList[1] + "개");
        printIncomeRate(lottoList.getAvailableLottoPlayNumber(), myReward);
    }

    public static void printIncomeRate(int numberOfLotto, int myReward){
        System.out.printf("총 수익률은 %.1f%%입니다.\n", (myReward * 100.0) / (numberOfLotto * 1000)); //상수
    }

}
