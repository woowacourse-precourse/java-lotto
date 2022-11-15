package Info;

import lotto.Lotto;
import lotto.LottoList;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;

public class PrintGameInfo {
    public static final char ZERO = '0';
    public static final String ERROR = "[ERROR] ";
    public static final String OPEN_SQUARE_BRACKETS = "[";
    public static final String CLOSE_SQUARE_BRACKETS = "]";
    public static final String NEXT_LINE = "\n";
    public static final String HYPHEN = " - ";
    public static final String COUNT_UNIT = "개";
    public static final String IS_NOT_DIGIT_STRING = "숫자 이외의 값이 존재합니다.";
    public static final String IS_EMPTY_STRING = "아무 값도 입력하지 않았습니다.";
    public static final String NOT_DIVDE_THOUSAND = "최소단위"+Integer.toString(LottoList.AMOUNT_UNIT)+"로 나눠지지 않습니다.";
    public static final String USER_INPUT_ZERO = "0원으로는 하나도 살 수 없습니다.";
    public static final String PURCHASE_COUNT = "개를 구매했습니다.";

    public static final String OVER_LOTTO_COUNT = "선택가능한 로또 숫자 갯수를 넘겼습니다.";
    public static final String OUT_OF_RANGE = "로또 숫자의 범위 밖의 숫자를 선택하였습니다.";
    public static final String DUPLICATE = "사용자의 입력 중 중복되는 값이 존재합니다.";
    public static final String BONNUS_NUMBER_EXIST = "보너스 번호의 값이 이미 당첨 번호에 선택되었습니다.";
    public static final String POINT_ERROR = "Status구하는 함수에 잘못된 상수 값이 들어왔습니다. 내부 로직 에러";

    public static final String PROFIT_FORMAT = "총 수익률은 ";

    public static void purchaseAmountInfo() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void winningNumberInfo() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public static void bonnusNumberInfo() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void winningTotalInfo() {
        System.out.println("당첨 통계\n---");
    }

    public static void printNextLine() {
        System.out.println(PrintGameInfo.NEXT_LINE);
    }

    public static void purchaseCount(BigInteger count) {
        System.out.println(count+PURCHASE_COUNT);
    }

    public static void lottoInfoList(LottoList lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            String lottoNumbers = lotto.numbersToString();
            System.out.println(OPEN_SQUARE_BRACKETS+lottoNumbers+CLOSE_SQUARE_BRACKETS);
        }
    }

    public static void lottoResultInfo(LottoList userLotto) {
        for (int winIndex=0; winIndex < LottoList.WIN_COUNT; winIndex++) {
            WinningStatus status = WinningStatus.getWinningStatusWithIndex(winIndex);
            long winningCount =  userLotto.getWinningCountValue(winIndex);
            System.out.println(getResultInfo(status.getPrintInfo(), Long.toString(winningCount)));
        }
    }

    public static void lottoProfitInfo(double profit) {
        System.out.println(getProfitFormat(profit));
    }

    private static String getResultInfo(String statusInfo, String countInfo) {
        return statusInfo + HYPHEN + countInfo + COUNT_UNIT;
    }


    public static String getIsNotDigitString() {
        return ERROR + IS_NOT_DIGIT_STRING;
    }
    public static String getIsEmptyString() {
        return ERROR + IS_EMPTY_STRING;
    }

    public static String getNotDivThousand() {
        return ERROR + NOT_DIVDE_THOUSAND;
    }

    public static String getUserInputZero() {
        return ERROR + USER_INPUT_ZERO;
    }

    public static String getOutOfRange() {
        return ERROR + OUT_OF_RANGE;
    }

    public static String getDuplicate() {
        return ERROR + DUPLICATE;
    }

    public static String getBonnusNumberExist() {
        return ERROR + BONNUS_NUMBER_EXIST;
    }

    public static String getPointError() {
        return ERROR + POINT_ERROR;
    }

    public static String getProfitFormat(double profit) {
        return PROFIT_FORMAT + String.format("%.1f%%입니다.", profit);
    }


}
