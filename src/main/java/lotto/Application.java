package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int count = Buy.buyLotto();
        List<Lotto> purchases = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            purchases.add(Buy.issueLotto());
        }
    }
}
