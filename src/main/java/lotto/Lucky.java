package lotto;
import java.util.List;

public class Lucky {
        LottoManager lottoManager = new LottoManager();

        public String lucky (List<Integer> numbers, List<Integer> mynumbers) {
            int total = lottoManager.lottoCompare(numbers, mynumbers);
            int lucky = lottoManager.countLotto(numbers, mynumbers);
            int out = total - lucky;

            if (total == 0) {
                return "낫싱";
            }
            else if (out == 0) {
                return lucky + "당첨";
            }
            return lucky + "개 당첨";
        }
}

