#로또 게임

##기능 목록

### WinningNumber.java
- [ ] 문자열을 Integer<List>로 변경 후 사이즈가 6인지 확인하며 WinningNumber 클래스의 numbers로 설정하는 생성자 - WinningNumber(String string)
- [ ] Integer<List>의 사이즈가 6인지 확인하는 메소드 -validate(List<Integer>)
- [ ] 사용자가 입력한 문자열을 Integer<List>로 돌려주는 메소드 - StringToIntegerList(String)
   - [ ] numberValidate(List<Integer>,int)
      - [ ] 숫자가 이미 리스트안에 존재하는지 확인하는 메소드 -ifNumbersAlreadyExist(List<Integer>,int)
      - [ ] 숫자가 정해진 범위안에 있는 숫자인지 확인하는 메소드 -checkIfNumberInRange(int)
   - [ ] getTemporaryNumber(int,char)
      - [ ] 문자가 '0'~'9'사이인지 확인하는 메소드 -checkifCharIsNumber(char)
      - [ ] ','가 나온다면 숫자가 0으로 시작하는지 확인하는 메소드 - checkIfNumberStartsWithZero(int)
- [ ] bonusNumber를 받고 만약에 이미 numbers에 있다면 에러 아니라면 변수 bonusNumber로 설정하는 메소드 -setBonusNumber
- [ ] 맴버변수 numbers를 돌려받는 메소드 -getNumbers
- [ ] 맴버변수 bonusNumber를 돌려받는 메소드 -getBonusNumbers

### JudgeMent.java
- [ ] 사용자의 로또 번호와 기존 로또 번호에서 몇개가 같은 지 돌려주는 메소드 - compareNumbers(List<integer>,List<Integer>)
- [ ] 보너스 넘버가 포함되어있는지 확인하는 메소드 -bonusCheck(List<Integer>,int,int)
- [ ] 맴버변수 correctResult를 돌려받는 메소드,correctResult는 각 Enum과 그에 해당하는 Integer가 들어있음-getCorrectResult()
- [ ] 맴버변수 correctResult를 초기화 한 후 각 로또 번호들과 당첨 번호를 비교하여 correctResult를 변경하는 메소드 -setCorrectResult
   - [ ] 로또 번호와 당첨번호를 비교하여 Reward를 반환하는 메소드 -getReward(numbers,WinningNumber)
      - [ ] 맞은 수에 따라 각각 다른 Reward를 반환하는 메소드 - checkReward(List<Integer>,WinningNumber,int)
   
   
### Game.java
- [ ] 게임을 시작할 때 처음 실행되며, 전체적인 출력과 모든 메소드의 1차메소드 -gameStart()
   - [ ] 구입금액을 입력받고 검사후 로또 번호들을 생성하는 메소드 -showBoughtNumbers()
      - [ ] 입력한 값이 기존 단위와 나눌 때 나눠떨어지는지 검사하는 메소드 - checkIfDivideWithThousand(String)
      - [ ] 로또 번호를 임의로 생성해주는 메소드 - getLotto(List<Lotto>)
   - [ ] 당첨번호와 보너스 넘버를 받고 WinningNumber 객체를 생성하는 메소드 -makeWinningNumber()
   - [ ] 로또 리스트와 WinningNumber객체를 받고 JudgeMent객체를 생성하고 결과를 출력하는 메소드 -showResult(List<Lotto>,WinningNumber)
- [ ] 수익률을 계산해주는 메소드