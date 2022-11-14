package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Ui {

    public int moneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyInput = Console.readLine();
        GetValidateInput getValidateInput = new GetValidateInput(moneyInput);

        return getValidateInput.getMoney();
    }

    public List<Integer> lottoInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoInput = Console.readLine();
        GetValidateInput getValidateInput = new GetValidateInput(lottoInput);

        return getValidateInput.getNumbers();
    }

    public int bonusInput(List<Integer> lotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine();
        GetValidateInput getValidateInput = new GetValidateInput(bonusInput);

        return getValidateInput.getBonus(lotto);
    }

    public void buyLottoOutput(List<LottoNumber> buyList) {
        int size = buyList.size();
        System.out.println(size + "개를 구매했습니다.");

        for (LottoNumber lottoNumber : buyList) {
            System.out.println(lottoNumber.getNumbers().toString());
        }
    }

    public void lottoResultTotalOutput(List<Integer> lottoResult) {
        System.out.println("당첨 통계\n" + "---");
        for (LottoResult result : LottoResult.values()) {
            System.out.println(result.getDetail() + lottoResult.get(result.getIndex()) + "개");
        }
    }

    public void totalProfitOutput(double profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
