 
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
      - LottoBundleResponseDto: 로또 구매 결과 반환용
      - LottoWinNumberDto: 입력한 당첨 번호
      - LottoBonusNumberDto: 입력한 보너스 번호
      - LottoQueryDto: 로또 당첨 결과 조회용
      - LottoQueryResponseDto: 로또 당첨 결과 반환용
    - entity
      - Account: 유저 ID 저장용
      - Lotto: 발행된 로또 번호 저장용
      - LottoBundle: 한 번에 구매한 로또 묶음 저장용
      - LottoRound: 한 회차에 구매된 모든 로또 묶음 저장용
      - WinNumber: 당첨 및 보너스 번호 저장용
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
      - .finishRound(): 현재 진행중인 회차를 종료합니다.
  - #### view
    - LottoBundleResponseView: 구매한 로또의 번호를 알려줍니다.
      - .stringify(): 로또 번호를 출력 형식에 맞게 문자열화 합니다.
    - LottoQueryResponseView: 로또 당첨 내역을 알려줍니다.
      - .stringify(): 당첨 내역을 출력 형식에 맞게 문자열화 합니다.
  - #### utils
    - InputReader
      - .readLine(): 콘솔로부터 입력을 받아옵니다.
    - Logger
      - .log(): 콘솔에 메시지를 출력합니다.
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

## 🔍 설계시 고려사항
![로또게임](https://user-images.githubusercontent.com/95671168/201872881-a0e37238-ed1b-43c8-aa50-e4074d4807f9.png)
* 서비스가 여러가지로 나뉜 이유:
  * 실제 로또를 서비스 한다고 생각했을 때, 어떤 기능이 일반 유저가, 어떤 기능이 운영자가 접근할 수 있는가에 대해 고민했습니다.
  * 만약 정말로 접근 권한이 둘로 나뉜다 하면 컨트롤러만 재설계 해서 부품 갈아 끼우듯 할 수 있도록 만들기 위해 노력했습니다.
* WinNumber 엔티티를 빌더패턴으로 만든 이유:
  * 만약 요구사항이 바뀌거나 기능을 추가하면서 프로그램 순서가 달라진다해도, 순서에 상관 없이 엔티티를 생성 할 수 있게 하기 위해서 빌더 패턴으로 작성했습니다. 
* Account 관련 기능이나 엔티티, 리포지토리 등을 만든 이유:
  * 실제로 서비스를 만든다면, 회차 개념이 있어 각 회차마다 각각의 유저의 구매내역을 따로 저장해야 한다고 생각했습니다.
  * 리포지토리에는 `roundId`마다 다른 구매 내역, 다른 당첨 번호를 저장할 수 있도록 했고, 각 라운드마다 `UserId`로 특정 유저의 구매 내역을 조회할 수 있도록 했습니다.
* Console.readLine 을 직접 호출하지 않고 utils에서 클래스로 감싸 준 이유:
  * 만약 외부 라이브러리에 의존해야하는 기능이 있다면, 사용하던 기능이 더이상 서비스되지 않을 때를 대비해야 한다고 생각했습니다.
  * 따라서 메서드를 코드 내에 직접 삽입하지 않고 따로 관리해서 필요 할 때 갈아 끼울 수 있도록 하는 게 유지보수에 좋을 것 같다고 생각했습니다.

## ✏ 과제를 진행하며 배운 점

* ### MVC 패턴이란? [[참조](https://murphymoon.tistory.com/entry/%EC%9A%B0%EC%95%84%ED%95%9C-%ED%85%8C%ED%81%AC-MVC-%EB%A6%AC%EB%B7%B0-%EB%A0%88%EC%9D%B4%EC%96%B4-MVC-%ED%8C%A8%ED%84%B4-5%EB%A0%88%EC%9D%B4%EC%96%B4)]

    **'기능에 따라 나눈 메서드들을 어떤 클래스에 담아야 하는지는 어떻게 알 수 있을까?'** 에 대한 가이드를 여러 개발자들이 수정에 수정을 거쳐 나온 템플릿이 바로 **MVC 패턴!**
    
  MVC 패턴은 프로그램에 필요한 기능들을 Model, View, Controller 세 레이어로 나누어 어디에 속하는지 분류해 놓은 기준이다.
  * Model: 데이터와 관련된 책임을 담당하는 레이어
  * View : 사용자에게 보일 사용자 인터페이스를 담당하는 레이어
  * Controller : Model과 View를 연결해주는 레이어

  입력은 Controller에게 가고, Controller는 값을 처리해줄 Model을 찾아 알아서 연결시켜 주고, 처리한 값을 View에 넘겨 결과물을 가공해 돌려주는 과정을 거친다.

  따라서 MVC 패턴을 사용하면 입출력을 담당하는 View와 로직을 담당하는 Model을 독립적으로 개발을 진행할 수 있게 된다. 
  
  유효성 검증은 보통 프론트엔드에서 처리해 들어오지만, 프리코스 과제 특성상 입력은 일관되게 `readLine()`을 통해 받으므로, DTO에서 처리하는 과정을 거치면 좋을 것 같다.

* ### Enum을 사용해 전략 패턴 구현하기 [[참조](https://doohyun.tistory.com/64)]
  Java 에서는 열거형에 행위(메소드)를 추가할 수 있다. 각 열거형 원소마다 다르게 구현한 메서드를 추가해준다면, 확장이 필요할 때 if문을 수정해 분기점을 늘리지 않고도 상황에 따라 다른 행위를 할 수 있도록, 즉, 다형성을 갖추게 할 수 있는 것이다.

  <details markdown="1">
  <summary>예제 코드</summary>

  ```java
  /**
  * CODE_FOR_SAMPLE 의 Enum 전략
  *
  * Created by Doohyun on 2017. 4. 25..
  */
  public enum EnumCodeForSampleStrategy {

  CODE_A (CODE.CODE_FOR_SAMPLE.CODE_A){
  @Override
  public void saveData() {
  saveDataForRootCode();
  }

       @Override
       public List<String> getChildCodeList() {
           return Arrays.asList(CODE.CODE_FOR_SAMPLE.CODE_A_1, CODE.CODE_FOR_SAMPLE.CODE_A_2);
       }
  },

  CODE_B (CODE.CODE_FOR_SAMPLE.CODE_B){
  @Override
  public void saveData() {
  saveDataForRootCode();
  }

       @Override
       public List<String> getChildCodeList() {
           return Arrays.asList(CODE.CODE_FOR_SAMPLE.CODE_B_1, CODE.CODE_FOR_SAMPLE.CODE_B_2, CODE.CODE_FOR_SAMPLE.CODE_B_3);
       }
  },

  /**
  * 기존 아무 일도 하지 않던 CODE A_1 은 아무것도 재정의하지 않음.
    */
    CODE_A_1 (CODE.CODE_FOR_SAMPLE.CODE_A_1);

  String code;

  EnumCodeForSampleStrategy(String code) {
  this.code = code;
  }

  public String getCode() {
  return code;
  }

  /**
  * 오직 루트코드만이 해야할 일 정의
  *
  * <pre>
  *     기존의 공통된 루트코드의 기능을 Concrete 메소드로 제작
  * </pre>
  */
  protected final void saveDataForRootCode() {
  System.out.printf("%s 관련 테이블 업데이트\n", getCode());

       System.out.println("하위 컬럼 업데이트");
       for (String code :  getChildCodeList()) {
           System.out.printf("%s 관련 테이블 업데이트\n", code);
       }
  }

  /**
  * 아무 행위도 하지 않는 Hooker
  *
  * <pre>
  *     선택적으로 기능을 정의할 것!
  * </pre>
  */
  public void saveData(){
  }

  /**
  * 아무 행위도 하지 않는 Hooker
  *
  * <pre>
  *     선택적으로 기능을 정의할 것!
  * </pre>
  */
  public List<String> getChildCodeList() {
  return Collections.emptyList();
  }
  }
  ```

  </details>
  
* ### DTO, DAO, Repository 이해하기 [[참조](https://azderica.github.io/00-java-repositorys/)]
  * DTO
    * 각각의 계층끼리 기능 동작에 필요한 데이터를 주고 받기 위해 정보를 담아놓는 객체. 즉, 계층이 아닌 물건이다.
    * 필요한 정보가 한 객체 안에 담겨 있기 때문에, 메서드가 받는 매개변수도 굉장히 깔끔해지고, 데이터를 찾기 쉬워진다. 
  * Repository
    * DB와 어플리케이션 사이에 존재해, 데이터를 조회해 어플리케이션으로 넘기거나, 어플리케이션에서 데이터를 받아 DB에 저장해주는 계층이다.
    * DTO로는 저장이 안되므로, Entity를 만들어줘야 한다.
  * Entity
    * 자바에서 DB 데이터를 조작할 수 있도록, 테이블과 필드를 1:1 매칭 시켜 놓은 객체이다.
    * Entity는 DB의 데이터를 전달해주고 Service에서 사용할 비즈니스 로직만을 가져야한다.
  * DAO
    * DTO에서 Entity로, 혹은 그 반대로 바꿔주는 역할을 하는 계층이다.
    * 특정 서비스가 Repository의 일부 기능만 사용할 수 있어야할 때(Ex. 유저가 당첨 번호를 조회 하되, 저장하면 안될 때), 기능을 DAO의 메소드로 분리해 접근을 못하도록 막을 수도 있다.