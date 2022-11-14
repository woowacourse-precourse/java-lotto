- Domain layer : 도메인 규칙을 갖고 있으며 비지니스를 해결하기 위해 필요한 것들이 있는 계층
- Application layer : 도메인 협력이 이루어지는 명세 계층
- Presentation layer : 사용자에게 정보를 보여주고 사용자의 명령을 해석하는 책임을 갖는 계층
- Infrastructure layer : 애플리케이션 동작 구동을 보장하는 계층

1. Domain layer
   - Lotto : lotto 번호 6개를 갖고 있는 Entity
     - validation
       - duplicatedNumberValidation : 같은 수가 있을 경우 검증 Method
       - lottoNumberSize : 사이즈가 6 이상일 경우 검증 Method
       - lottoNumberRangeCheck : 로또 숫자 범위 검증 Method
       - matchNumbers : 로또 넘버 매칭 Method
         - hasNumber : 매칭 Hit 시 Count Method
       - printLottoNumbers : 로또 번호 출력 메서드
       - currentLottoNumbers : 로또 번호(List<Integer> type) 반환 Method
       
   - Money : 사용자의 돈 Entity
     - moneyValidation : 돈 검증 Method
     - currentTime : 값에 따른 게임 횟수 Return Method
     - currentMoney : 현재 갖고 있는 돈 Return Method

   - User : 사용자 Entity, Money와 lottos를 갖고 있다.
     - currentUserLottos : 사용자의 로또들을 Return 해주는 Method
     - printWholeLottoNumbers : 유저의 총 로또 번호를 출력해주는 Method
     - settingLottos : 게임 횟수만큼 로또를 구입하는 Method
       - immutableToMutableNumbers : List.of()로 받아오는 Immutable list를 Mutable로 변경하는 Method
     - printCurrentTime : User가 갖고 있는 현금을 String 으로 Return하는 Method

   - LottoMachine : Lotto 정답 번호 구성 담당 Entity. Money를 갖고 있습니다.
     - bonusNumberValidation : 보너스 번호에 관한 검증 Method
     - currentBonusNumber : 현재 보너스 번호 Return Method
     - currentMachineNumbers : 현재 기계의 로또 Return Method
     - ArrayToLottoNumbers : 문자열로 받아온 로또 번호를 List<Integer>로 변환하는 Method
     - lottoNumbersArrayValidation : 받아온 문자들이 숫자인지 판단하는 Method
       - eachLottoNumberValidation : 각각의 문자 숫자 판단 Method
   
   - LottoNumberMatcher : 사용자 로또와 기계의 로또를 비교, 맞추는 Entity
   - MatchReport : 각 게임의 결과 값을 저장하는 VO
   - Report : 게임 결과를 계산하는 Entity
   - Rank : 게임 순위에 대한 상금과 메세지를 갖고 있는 Enum
   
   Generator <<Interface>>
   - project 구동을 위해 필요한 것들을 명세해 놓은 Interface 

2. Infrastructure layer
   
   - GeneratorImpl : 명세에 대한 구현체
     - numberSeparator : 숫자 분리 Method
     - generateLotto : 기계에 입력될 로또 번호 생성 Method
     - generateBonusLottoNumber : 기계에 입력될 로또 보너스 번호 생성 Method

3. Application Layer

   - 정의한 모든 행위들을 조합하는 run Method

4. Common
   
   - ConsoleOut : 출력 UI와 관련된 메세지 정의
