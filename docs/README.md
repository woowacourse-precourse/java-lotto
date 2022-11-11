 
## 🚀 기능 목록

- ### lotto 패키지
  - #### data
    - type
      - MessageType: 로또 게임 진행시 콘솔 출력 메시지
      - ErrorType: 에러 발생 종류
      - StepType: 로또 구매의 진행 단계
      - CommandType: 입력 명령어 종류
      - LottoResultType: 로또 당첨 등급과 금액
      - ConstantNumberType: 로또 숫자 갯수, 최소, 최대값 등의 상수
    - dto
      - Lotto: 로또 1매에 포함된 숫자들
        - .validate(): 숫자 개수를 검증한다
      - LottoPurchaseDto: 한 회에 구매한 모든 로또 
      - LottoWinNumberDto: 당첨 로또 숫자 
  - #### controller
    - LottoController
      - .run(): 로또 게임을 실행합니다.
  - #### service
    - LottoService
      - .buy(): 로또를 구매합니다.
      - .decideWinner(): 당첨 번호를 정합니다.
      - .decideBonus(): 보너스 번호를 정합니다.
  - #### view
    - LottoView
      - .resolveLottoBought(): 구매한 로또의 번호를 알려줍니다.
      - .resolveLottoResult(): 로또 당첨 내역을 알려줍니다.
  - #### utils
    - RandomNumberGenerator
      - .generateNumbersInRange(): 범위 내의 임의의 숫자를 지정된 갯수만큼 줍니다.
    - Validator
      - .isDivisibleBy(): 한 숫자가 다른 숫자로 나누어 떨어지는지 알려줍니다.
      - .isInBetween(): 한 숫자가 다른 두 숫자 사이의 값인지 알려줍니다.
      - .isPatternOf(): 특정 문자열이 정규식과 일치하는지 알려줍니다.
      - .hasSizeOf(): 배열의 원소 개수를 확인한다.
      - .hasUniqueElements(): 배열에 중복된 원소가 있는지 확인한다.

## 🔍 설계시 고려한 문제들
* '입력 순서가 뒤바뀌면 어떻게 하지?'
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
  