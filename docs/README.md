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
   - Money : 사용자의 돈 Entity
   - User : 사용자 Entity, Money와 lottos를 갖고 있다.
   - WinningNumbers : 당첨 Entity
   - Ball : 당첨 공 Entity
   - LottoMachine : Lotto 번호 구성 담당 Entity. Money를 갖고 있습니다.

   util
   - NumbersSeparator : 문자열을 쉽표 기준으로 나눠 Sting[] array를 return 해주는 method
   - RandomNumberGenerator : camp.nextstep.edu.missionutils.Randoms 에서 사용되는 Random method를
     통해 난수 생성
   - 

2. Presentation layer
   - LottoProcess : lotto application 에서 사용자의 입력과 명령을 해석하는 Method

3. Infrastructure layer
   
   - RandomNumberConversion : String type to List<Integer> type Numbers Method

4. Common
   - Common Package has Lotto Process Whole Message Definition
   ConsoleOut
     - message 정의
