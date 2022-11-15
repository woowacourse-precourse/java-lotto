package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Money {
    public String getAmount() {
        String amount;
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        try {
            amount = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return amount;
    }

    public int lottoCount(String amount) {
        int money = Integer.parseInt(amount);
        return (money / 1000);
    }
}
