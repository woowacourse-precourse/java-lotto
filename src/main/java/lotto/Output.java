package lotto;

public class Output {

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottoNumber(LottoNumbers lottoNumbers) {
        for (Lotto numbers : lottoNumbers.getLottoNumbers()) {
            System.out.println(numbers.getNumbers());
        }
    }

    public static void printRankingMsg() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

}
