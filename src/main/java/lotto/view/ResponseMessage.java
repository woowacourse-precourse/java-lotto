package lotto.view;

public class ResponseMessage {
    static StringBuilder responseMessage = new StringBuilder();

    public static void initStringBuilder() {
        responseMessage.setLength(0);
        responseMessage.append('\n');
    }

    public static void printPurchaseMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void printLottoNumbers(int lottoNumber) {
        responseMessage.append('\n')
                .append(lottoNumber)
                .append("개를 구매했습니다.");
        System.out.println(responseMessage);
    }

    public static void printWinningNumbers() {
        initStringBuilder();
        responseMessage.append("당첨 번호를 입력해 주세요.");
        System.out.println(responseMessage);
    }

}
