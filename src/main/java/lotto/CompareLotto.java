package lotto;

public class CompareLotto {

    public static int first, second, third, fourth, fifth;

    //내 로또와 비교
    public static void compareLotto() {
        for (int i = 0; i < LottoInput.numberOfLotto; i++) {
            if (LottoGenerator.myLottoNumbers.get(i).contains(Lotto.bonusNum)) {
                LottoGenerator.myLottoNumbers.get(i).retainAll(Application.winningNumbers);
                int checkLotto = LottoGenerator.myLottoNumbers.get(i).size();
                if (checkLotto == 3) {
                    fifth++;
                }
                if (checkLotto == 4) {
                    fourth++;
                }
                if (checkLotto == 5) {
                    second++;
                }
                if (checkLotto == 6) {
                    first++;
                }
            }
            if (!LottoGenerator.myLottoNumbers.get(i).contains(Lotto.bonusNum)) {
                LottoGenerator.myLottoNumbers.get(i).retainAll(LottoGenerator.myLottoNumbers.get(i));
                int checkLotto = LottoGenerator.myLottoNumbers.get(i).size();
                if (checkLotto == 3) {
                    fifth++;
                }
                if (checkLotto == 4) {
                    fourth++;
                }
                if (checkLotto == 5) {
                    third++;
                }
                if (checkLotto == 6) {
                    first++;
                }
            }
        }
    }

    public static void printCompareLotto() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + fifth);
        System.out.println("4개 일치 (50,000원) - " + fourth);
        System.out.println("5개 일치 (1,500,000원) - " + third);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) -" + second);
        System.out.println("6개 일치 (2,000,000,000) - " + first);
    }

    public static void printRateOfReturn(){
        double getReturn = (fifth * 5000) + (fourth * 50000) + (third * 1500000) + (second * 30000000) + (first * 2000000000);
        double rateOfReturn = (getReturn / LottoInput.inputMoney)*100;
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");

    }
}
