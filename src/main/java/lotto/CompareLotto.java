package lotto;

import java.util.List;

public class CompareLotto {

    public static int first, second, third, fourth, fifth;
    private static final String COUNT = "개";
    private static boolean bonus = false;

    //내 로또와 비교
    public static int compareLotto(List<Integer> lotto) {
        for (int i = 0; i < LottoInput.numberOfLotto; i++) {
            if (LottoGenerator.myLottoNumbers.get(i).contains(Lotto.bonusNum)) {
                bonus = true;
            }
            LottoGenerator.myLottoNumbers.get(i).retainAll(lotto);
            if (LottoGenerator.myLottoNumbers.get(i).size() == 3) {
                return fifth++;
            }
            if (LottoGenerator.myLottoNumbers.get(i).size() == 4) {
                return fourth++;
            }
            if (LottoGenerator.myLottoNumbers.get(i).size() == 5  && bonus == true) {
                return second++;
            }
            if (LottoGenerator.myLottoNumbers.get(i).size() == 5) {
                return third++;
            }
            if (LottoGenerator.myLottoNumbers.get(i).size() == 6) {
                return first++;
            }
        }
        return 0;
    }


    public static void printCompareLotto() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + fifth + COUNT);
        System.out.println("4개 일치 (50,000원) - " + fourth + COUNT);
        System.out.println("5개 일치 (1,500,000원) - " + third + COUNT);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + COUNT);
        System.out.println("6개 일치 (2,000,000,000원) - " + first + COUNT);
    }

    public static void printRateOfReturn() {
        double getReturn =
                (fifth * 5000) + (fourth * 50000) + (third * 1500000) + (second * 30000000) + (first * 2000000000);
        double rateOfReturn = (getReturn / LottoInput.inputMoney) * 100;
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");

    }
}
