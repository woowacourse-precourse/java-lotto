 
## 🚀 기능 목록

- ### lotto 패키지
  - #### data
    - type
      - MessageType: 로또 게임 진행시 콘솔 출력 메시지 모음
      - ExceptionType: 발생하는 에러 종류 모음
      - StepType: 로또 게임의 진행 단계 모음
      - LottoResultType: 로또 당첨 등급과 금액 모음
      - ConstantNumberType: 로또 숫자 갯수, 최소, 최대값 등의 상수 모음
      - PatternType: 정규식에 사용되는 문자열 모음
    - dto
      - LottoDto: 입력 받을 때 생성되는 로또 숫자
      - LottoBundleDto: 액수를 입력해 생성되는 로또 묶음
      - LottoWinNumberDto: 입력한 당첨 번호
      - LottoBonusNumberDto: 입력한 보너스 번호
      - LottoQueryDto: 구매 로또 조회용도
    - entity
      - Lotto: 저장되는 로또
      - LottoBundle: 저장되는 로또 묶음
      - LottoRound: 한 회차에 구매된 모든 로또 묶음
      - WinNumber: 저장되는 당첨 및 보너스 번호
    - dao
      - AccountDao: 계정 서비스에서 필요한 저장소 조작 메서드를 제공합니다.
      - UserDao: 유저 서비스에서 필요한 저장소 조작 메서드를 제공합니다.
      - AdminDao: 관리자 서비스에서 필요한 저장소 조작 메서드를 제공합니다.
    - repository
      - AccountRepository: 계정 저장소
      - LottoBundleRepository: 구매 로또 저장소
      - LottoWinNumberRepository: 당첨 번호 저장소
  - #### controller
    - LottoController
      - .run(): 로또 게임을 실행합니다.
      - .purchaseLotto(): 로또를 구매합니다.
      - .decideWinNumber(): 당첨 번호를 정합니다.
      - .decideBonusNumber(): 보너스 번호를 정합니다.
      - .getResult(): 결과를 출력합니다.
  - #### service
    - AccountService: 유저마다 다른 아이디를 부여해주는 서비스입니다.
      - .getNewId(): 새로운 아이디를 발급합니다. 
    - UserService: 일반 유저가 접근 가능한 서비스입니다.
      - .purchaseLottoBundle(): 로또를 구매합니다.
      - .getMyResult(): 로또 당첨 결과를 조회합니다.
    - AdminService: 관리자가 접근 가능한 서비스입니다.
      - .setWinNumber(): 당첨 번호를 정합니다.
      - .setBonusNumber(): 보너스 번호를 정합니다.
      - .confirmWinNumber(): 입력 받은 번호들을 최종적으로 저장합니다.
  - #### view
    - LottoBundleView: 구매한 로또의 번호를 알려줍니다.
      - .stringify(): 로또 번호를 출력 형식에 맞게 문자열화 합니다.
    - LottoResultView: 로또 당첨 내역을 알려줍니다.
      - .stringify(): 당첨 내역을 출력 형식에 맞게 문자열화 합니다.
  - #### utils
    - InputReader
      - .readLine(): 콘솔로부터 입력을 받아옵니다.
    - Logger
      - .log(): 콘솔에 메시지를 남깁니다.
    - RandomNumberGenerator
      - .generateNumbersInRange(): 범위 내의 임의의 숫자를 지정된 갯수만큼 줍니다.
    - Validator
      - StringValidator
        - .isNumeric(): 문자열이 숫자 형태인지 확인합니다.
        - .matchesPatternOf(): 문자열이 정규식과 일치하는지 알려줍니다.
      - IntegerValidator
        - .isDivisibleBy(): 한 숫자가 다른 숫자로 나누어 떨어지는지 알려줍니다.
        - .isInBetween(): 한 숫자가 다른 두 숫자 사이의 값인지 알려줍니다.
      - CollectionValidator
        - .hasSizeOf(): 배열의 원소 개수가 지정된 숫자와 일치하는지 확인합니다.
        - .hasUniqueElementsOnly(): 배열의 원소가 모두 유일한지 확인합니다.
    - DecimalFormatter
      - formatNumber(): 숫자를 형식에 맞게 바꿔줍니다.

## 🔍 설계시 고려한 문제들
* '단계를 옮겨다니는 기능으로 입력 순서가 뒤바뀌면 어떻게 하지?'
  * LottoWinNumberDto에 빌더 패턴을 적용

## ✏ 과제를 진행하며 배운 점

* ### MVC 패턴이란?[[참조](https://murphymoon.tistory.com/entry/%EC%9A%B0%EC%95%84%ED%95%9C-%ED%85%8C%ED%81%AC-MVC-%EB%A6%AC%EB%B7%B0-%EB%A0%88%EC%9D%B4%EC%96%B4-MVC-%ED%8C%A8%ED%84%B4-5%EB%A0%88%EC%9D%B4%EC%96%B4)]

    **'기능에 따라 나눈 메서드들을 어떤 클래스에 담아야 하는지는 어떻게 알 수 있을까?'** 에 대한 가이드를 여러 개발자들이 수정에 수정을 거쳐 나온 템플릿이 바로 **MVC 패턴!**
    
  MVC 패턴은 프로그램에 필요한 기능들을 Model, View, Controller 세 레이어로 나누어 어디에 속하는지 분류해 놓은 기준이다.
  * Model: 데이터와 관련된 책임을 담당하는 레이어
  * View : 사용자에게 보일 사용자 인터페이스를 담당하는 레이어
  * Controller : Model과 View를 연결해주는 레이어

  입력은 Controller에게 가고, Controller는 값을 처리해줄 Model을 찾아 알아서 연결시켜 주고, 처리한 값을 View에 넘겨 가공된 결과물을 보여주는 과정을 거친다.

  따라서 MVC 패턴을 사용하면 입출력을 담당하는 View와 로직을 담당하는 Model을 독립적으로 개발을 진행할 수 있게 된다. 
  
  유효성 검증은 보통 프론트엔드에서 처리해 들어오지만, 프리코스 과제 특성상 입력은 일관되게 `readLine()`을 통해 받으므로, 모델까지 접근 후 유효성 검사해야 해야겠다.
* ### Enum을 사용해 전략 패턴 구현하기[[참조](https://doohyun.tistory.com/64)]
  