package type;

import lotto.LottoGroups;
public enum Comments {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_TOTAL("당첨 통계\n---"),
    LOTTO_NUMBER("개를 구매했습니다."),
    YIELD_START("총 수익률은 "),
    YIELD_END("%입니다.");

    private String context;

    Comments(String context) {
        this.context = context;
    }

    public static void print(Comments comments) {
        System.out.println(comments.context);
    }

    public static void printLottos(LottoGroups lottos) {
        System.out.println(lottos.getLottosSize() + Comments.LOTTO_NUMBER.context);
        lottos.getLottos().stream().forEach(lotto -> System.out.println(lotto.getLotto()));
    }

    public static void printYield(String yield) {
        System.out.println(Comments.YIELD_START.context + yield + Comments.YIELD_END.context);
    }
}
