package constant;

public class Message {
    // 공통 정보 변수
    public static final int SMALLESTNUMBER = 1;
    public static final int LARGESTNUMBER = 45;
    public static final int LOTTOLENGTH = 6;
    public static final int BONUSLENGTH = 1;
    public static final int ONETIME = 1;
    public static final int WINLOTTO = 3;
    public static final int THOUSAND = 1000;
    public static final int HUNDRED = 100;
    public static final int ZEROINIT = 0;
    public static final int ZERO = 0;
    public static final int TWOLETTERS = 2;

    // 로또 당첨 종류 분리 변수
    public static final int RANKFIFTH = 3;
    public static final int RANKFOURTH = 4;
    public static final int RANKTHIRD = 5;
    public static final int RANKSECOND = 7;
    public static final int RANKFIRST = 6;

    // 로또 당첨 종류별 상금 변수
    public static final int RANKFIFTHPRIZEMONEY = 5000;
    public static final int RANKFOURTHRIZEMONEY = 50000;
    public static final int RANKTHIRDRIZEMONEY = 1500000;
    public static final int RANKSECONDRIZEMONEY = 30000000;
    public static final int RANKFIRSTRIZEMONEY = 2000000000;

    // 오류 출력 메시지
    public static final String IsNotNumberMessage = "[ERROR] 숫자 입력이여야 합니다.";
    public static final String WrongSizeWinningNumbersMessage = "[ERROR] 당첨 번호 길이는 6이여야 합니다.";
    public static final String WrongSizeLottoNumbersMessage = "[ERROR] 로또 번호 길이는 6이여야 합니다.";
    public static final String WrongSizeBonusNumberMessage = "[ERROR] 보너스 번호 길이는 1이여야 합니다.";
    public static final String WrongRangeMessage = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DuplicationMessage = "[ERROR] 숫자가 중복되지 않아야 합니다.";
    public static final String IsNotAscendingOrderMessage = "[ERROR] 숫자가 오름차순이어야 합니다.";
    public static final String IsNotThousandUnitMessage = "[ERROR] 1000원 단위의 금액이여야 합니다.";


    // 안내 출력 메시지
    public static final String EnterPurchasingAmountMessage = "구입 금액을 입력해주세요.";
    public static final String PurchaseMessage =  "개를 구매했습니다.";

    public static final String EnterWinningNumberMessage = "당첨 번호를 입력해주세요.";
    public static final String EnterBonusNumberMessage = "보너스 번호를 입력해주세요.";
    public static final String Comma = ",";
    public static final String CommaSpace = ", ";
    public static final String StartSquareBrackets = "[";
    public static final String EndSquareBrackets = "]";

    public static final String WinStatistics = "당첨 통계" + "\n" + "---";
    public static final String RankFifthMessage = "3개 일치 (5,000원) - ";
    public static final String RankFourthMessage = "4개 일치 (50,000원) - ";
    public static final String RankThirdMessage = "5개 일치 (1,500,000원) - ";
    public static final String RankSecondMessage = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String RankFirstMessage = "6개 일치 (2,000,000,000원) - ";
    public static final String RateOfProfitMessage = "총 수익률은 ";
    public static final String Piece = "개";
    public static final String Description = "%입니다.";
}
