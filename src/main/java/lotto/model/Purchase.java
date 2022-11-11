package lotto.model;

import lotto.view.OutputView;

public class Purchase {
    /*  private static final String MONEY_REGEX = "/^[0-9]*$/";*/
    private final int issueCount;

    public Purchase(String input) {
  /*      if (!Pattern.matches(MONEY_REGEX, input)) {
            throw new IllegalArgumentException("[ERROR] 올바른 로또 구입 금액을 입력해 주세요.");
        }*/
        int money = Integer.parseInt(input);
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 올바른 로또 구입 금액을 입력해 주세요.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 가능합니다.");
        }
        this.issueCount = money / 1000;
        OutputView.printIssueCount(issueCount);
    }

    public int get() {
        return issueCount;
    }
}
