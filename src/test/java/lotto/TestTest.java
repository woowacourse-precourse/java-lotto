package lotto;

import Service.LottoService;
import domain.Rank;
import domain.Reward;
import org.junit.jupiter.api.Test;
import view.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestTest {
    SystemMessage systemMessage = new SystemMessage();
    List<Integer> lotto = List.of(3,4,5,6,10,11,19);
    List<Integer> user1 = List.of(3,4,5,6,19,25); // 4
    List<Integer> user2 = List.of(3,4,5,6,10,25); // 3
    List<Integer> user3 = List.of(3,4,5,6,10,19); // 2
    List<Integer> user4 = List.of(3,4,5,6,10,11); // 1
    List<Integer> user5 = List.of(3,4,5,19,25,42); // fifth
    List<Integer> user6 = List.of(3,4,21,19,40,41); // fail

    List<List<Integer>> user = List.of(List.of(1,2,3,4,41,46), List.of(3,5,6,8,10,19), List.of(15,16,17,18,21,22));
    List<List<Integer>> users = List.of(List.of(3,4,5,6,19,25), List.of(3,4,5,6,10,25),
            List.of(3,4,5,6,10,19), List.of(3,4,5,6,10,11), List.of(3,4,5,19,25,42), List.of(3,4,21,19,40,41)
            ,List.of(3,4,5,6,10,11));

    @Test
    public void 실험() throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
//
//        System.out.println("******");
//        Rank rank1 = Rank.winningCondition(lotto, user1);
//        System.out.println(rank1);
//        Rank rank2 = Rank.winningCondition(lotto, user2);
//        System.out.println(rank2);
//        Rank rank3 = Rank.winningCondition(lotto, user3);
//        System.out.println(rank3);
//        Rank rank4 = Rank.winningCondition(lotto, user4);
//        System.out.println(rank4);
//        Rank rank5 = Rank.winningCondition(lotto, user5);
//        System.out.println(rank5);
//        Rank rank6 = Rank.winningCondition(lotto, user6);
//        System.out.println(rank6);
        Map<Rank, Integer> map = new HashMap<>();
        systemMessage.mapSetting(map);

        for(List<Integer> list : users){
            Rank tests = Rank.winningCondition(lotto, list);
            System.out.println(tests.getRanking());
            System.out.println("*******");
//            int[] count = new int[6];
//            count = systemMessage.getCount(tests);
//            System.out.print(Arrays.toString(count) + " ");
//            System.out.println("");
            systemMessage.getCount(tests, map);
        }

        for(Rank rank : map.keySet()){
            System.out.printf(rank.getRanking() + " ");
        }
        System.out.println("*************");
        for(int val : map.values()){
            System.out.printf(val + " ");
        }

        System.out.println(map.get(Rank.FIRST) + "개");
        System.out.println("KKKKKKKKKKKKKKKKKKKKKK");
        systemMessage.winningMessage();
        systemMessage.countMessage(map);

        Reward reward = new Reward();
        Long sum = reward.totalReward(map);
        System.out.println(sum);

    }
}
