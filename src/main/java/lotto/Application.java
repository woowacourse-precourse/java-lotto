package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoProgram lottoProgram = new LottoProgram();
        try {
            lottoProgram.start();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
