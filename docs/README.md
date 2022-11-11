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
     - printCurrentTime() : 로또 총 발행 횟수를 출력해주는 Method
     - printUserLottosNumbers() : 유저의 총 로또 번호를 출력해주는 Method

   - LottoMachine : Lotto 번호 구성 담당 Entity. Money를 갖고 있습니다.
     - bonusNumberValidation() : 보너스 번호에 관한 검증 Method

   Generator <<Interface>>
   - project 구동을 위해 필요한 것들을 명세해 놓은 Interface 

2. Presentation layer
   - LottoProcess : lotto application 에서 사용자의 입력과 명령을 해석하는 Method

3. Infrastructure layer
   
   - GeneratorImpl : 명세에 대한 구현체
     - numberSeparator : 숫자 분리 Method
     - lottoNumbersGenerator : 난수 6자리 생성 Method

4. Common
   - Common Package has Lotto Process Whole Message Definition
   ConsoleOut
     - message 정의
