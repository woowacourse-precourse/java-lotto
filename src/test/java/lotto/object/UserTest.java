import static org.junit.jupiter.api.Assertions.*;
class UserTest {
  
    @Test
    void create_Lottery_nums() {
        User user = new User();
        assertThat(user.TestReturnSize()).isEqualTo(6);
    }

}