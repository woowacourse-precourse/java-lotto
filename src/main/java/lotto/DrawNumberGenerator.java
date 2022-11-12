package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class DrawNumberGenerator {
    public static List<Lotto> Lottos;

    public void purchaseOutput() {
        int lottoCount = ConsoleInput.purchaseCount;
        System.out.println(Integer.toString(lottoCount)+LottoMessage.PURCHASE_MESSAGE);
        for (int count = 0;count<lottoCount;count++){
            List<Integer> oneLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto oneLotto = new Lotto(oneLottoNumbers);
            Lottos.add(oneLotto);
        }
    }


}
