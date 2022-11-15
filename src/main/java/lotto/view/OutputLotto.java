package lotto.view;

import lotto.domain.Game;
import lotto.domain.LottoProperties;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class OutputLotto{
    public static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void printResult(Game game) throws IOException {
        printPrefix();
        printGameCount(game);
        printAllResult(game);
        bw.flush();
    }
    private static void printPrefix() throws IOException{
        bw.append("당첨 통계\n");
        bw.append("---\n");
        bw.flush();
    }
    private static void printGameCount(Game game) throws IOException{
        int i =0;
        for(LottoProperties name:LottoProperties.values()){
            if (name==LottoProperties.LOTTO_LOOSE){
                break;
            }
            bw.append(String.format(name.getStrResultFormat(),name.getCorrect(),name.getSprice(), game.getGameCount()[i++]));
        }
    }
    private static void printAllResult(Game game) throws IOException{
        bw.append("총 수익률은 "+ game.getResult()+"%입니다.\n");
    }
    public static void numberPrint(List<Integer> numbers){
        try {
            bw.append("[");
            for (int i = 0; i < numbers.size(); i++) {
                bw.append(numbers.get(i).toString());
                if (i != numbers.size() - 1) {
                    bw.append(", ");
                }
                if (i == numbers.size() - 1) {
                    bw.append("]\n");
                }
            }
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
