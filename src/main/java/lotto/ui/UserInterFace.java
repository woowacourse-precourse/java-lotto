package lotto.ui;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class UserInterFace {
    public int inputInteger() {
        try {
            String input = Console.readLine();
            int result = Integer.valueOf(input);
            return result;
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException();
        }
    }
    
    public void printLottos(List<List<Integer>> lottos) {
        print(lottos.size() + "개를 구매했습니다.\n");

        for (int index = 0; index < lottos.size(); index++) {
            List<Integer> lotto = lottos.get(index);
            print(lotto.toString() + "\n");
        }
        
        print("\n");
    }
    
    public void print(String text) {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            bufferedWriter.write(text);
            bufferedWriter.flush();
        } catch (IOException error) {
            error.printStackTrace();
        }

    }
}
