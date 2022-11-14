package lotto.service;

import lotto.data.repository.UserRepository;

public class LogInService {

    private final UserRepository userRepository;

    public LogInService() {
        userRepository = UserRepository.getInstance();
    }

    /**
     * 유저별 구매 로또를 구별하기 위해 유저 아이디 번호를 사용했습니다.
     */
    public Long getNewId() {
        return userRepository.addNewUser();
    }
}
