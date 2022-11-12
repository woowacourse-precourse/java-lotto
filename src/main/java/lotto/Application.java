package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoStore lottoStore = new LottoStore();
        lottoStore.insert();
        lottoStore.getLottoPaper();
    }
}
