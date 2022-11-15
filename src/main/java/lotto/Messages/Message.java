package lotto.Messages;

public class Message {
    public static final String same_6 = "6개 일치 (2,000,000,000원)";
    public static final String same_5_and_bonus = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    public static final String same_5 = "5개 일치 (1,500,000원)";
    public static final String same_4 = "4개 일치 (50,000원)";
    public static final String same_3 = "3개 일치 (5,000원)";

    public static final String MoneytoBuy = "구입금액을 입력하세요.";
    public static final String BuyCount = "개를 구매했습니다.";
    public static final String InputWinningNumber = "당첨 번호를 입력해주세요.";
    public static final String InputWinningBonus = "보너스 번호를 입력해 주세요.";
    public static final String printresult = "당첨 통계";

    public static final String error = "[ERROR] ";
    public static final String NotInputMoney = error + "로또 구입 금액을 입력하지 않았습니다.";
    public static final String OnlyInput1000 = error + "1,000원 단위로 입력해야 합니다.";
    public static final String OnlyInputNumber = error + "숫자만 입력가능합니다.";
    public static final String NotEnoughNumber = error + "로또 번호의 개수가 6개가 아닙니다.";
    public static final String HaveSameNumber = error + "로또 번호에 중복된 숫자가 있습니다.";
    public static final String NotInRange = error + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String BonusNotInRange = error + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String BonusSameLotto = error + "보너스 번호가 당첨 번호와 중복됩니다.";


}
