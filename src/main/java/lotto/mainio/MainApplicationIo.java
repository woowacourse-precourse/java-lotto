package lotto.mainio;

import lotto.lottocomparator.WinningLotto;
import lotto.lottonumber.Lotto;
import lotto.lottonumber.LottoNumber;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static lotto.inputparser.InputParser.*;
import static lotto.lottonumber.LottoNumberGenerator.generateLotto;


/**
 * 상황에 맞는 입출력을 담당하는 클래스입니다.
 */
public class MainApplicationIo {
    public static Scanner scanner;

    private static final List<String> statOutput = Arrays.asList("6개 일치 (2,000,000,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ", "5개 일치 (1,500,000원) - ", "4개 일치 (50,000원) - ",
            "3개 일치 (5,000원) - ");

    /**
     * 구입금액을 입력받고,해당 구입금액이 정상적인 값인지 판단한 후 구입금액을 반환합니다.
     * @retur 구입금액
     */
    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = scanner.nextLine();
        return parsePurchaseAmount(purchaseAmount);
    }

    /**
     * 구입한만큼 로또를 생성하고, 생성한 로또를 출력한 후, 생성한 로또들을 반환합니다.
     * @param lottoNumber 구입한 로또의 장수
     * @return 생성된 로또들
     */
    public static List<LottoNumber> buyLotto(int lottoNumber) {
        System.out.println(lottoNumber + "개를 구매했습니다.");
        List<LottoNumber> lottoNumbers = generateLotto(lottoNumber);
        for (LottoNumber lotto : lottoNumbers) {
            System.out.println(outputLotto(lotto));
        }
        System.out.println();
        return lottoNumbers;
    }

    /**
     * 당첨 번호를 입력받고,로또 번호로 파싱합니다.
     * @return 파싱된 로또 번호
     */
    public static Lotto inputWinningLotto() {
        System.out.println("당첨 번호를 입력해주세요.");
        String winningString = scanner.nextLine();
        System.out.println();
        return parseLottoString(winningString);
    }

    /**
     * 보너스 번호에 해당하는 문자열을 입력받고, 보너스 번호를 파싱합니다.
     * @return 보너스 번호
     */
    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusString = scanner.nextLine();
        System.out.println();
        return parseBonusNumber(bonusString);
    }

    /**
     * 로또 당첨 결과를 바탕으로 통계를 출력합니다.
     * @param result 로또 당첨 결과
     */
    public static void printStat(WinningLotto result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 4; i >= 0; i--) {
            System.out.println(statOutput.get(i) + result.getWinningNumbers().get(i) + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.1f", result.getRateOfRevenue()) + "%입니다.");
    }

    /**
     * 특정 로또를 출력 형식에 맞게 변환하여 반환합니다.
     *
     * @param lottoNumber 특정 로또
     * @return 출력되는 로또 문자열
     */
    private static StringBuilder outputLotto(LottoNumber lottoNumber) {
        StringBuilder result = new StringBuilder("[");
        for (int number : lottoNumber.getGeneralLottoNumber().getNumbers()) {
            result.append(number);
            result.append(", ");
        }
        result.replace(result.length() - 2, result.length(), "]");
        return result;
    }

}
