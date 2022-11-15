package lotto;

public class LottoCount {
    public void lottoCount (int inputMoney) {
        int myCount = inputMoney % 1000;
        System.out.println(myCount + "개를 구매했습니다.");
    }
}
