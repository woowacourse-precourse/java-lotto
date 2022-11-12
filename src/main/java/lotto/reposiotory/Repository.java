package lotto.reposiotory;

import lotto.domain.User;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private static final Map<Integer,User> map=new HashMap<>();
    private static final Repository repository=new Repository();

    private Repository() {
    }
    public void save(User user) {
        user.setId(map.size()+1);
        map.put(user.getId(),user);
    }

    public static Repository createRepository(){
        return repository;
    }

    public User findById(int id) {
        return map.get(id);
    }
}
