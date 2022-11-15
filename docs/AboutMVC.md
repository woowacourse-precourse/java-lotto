# MVC 패턴

---

## MVC 패턴

---

- Model - View - Controller 의 약자로, 애플리케이션을 3가지 역할로 구분한 개발 방법론이다.

- Model, View, Controller의 컴포넌트들은 각자의 고유한 역할이 정해져 있다.

- 유지보수에 매우 유용한 디자인 패턴이다.

- 보통 다음과 같이 동작한다.

    - User는 View를 본다.
    - User가 View를 통해 요청을 보낸다.
    - 해당 요청은 Controller에게 전달된다.
    - Controller는 Model을 통해 데이터를 가져온다.
    - 가져온 데이터를 토대로 View를 제어하여 User에게 전달한다.

  -> 즉, User <-> View <-> Controller <-> Model 의 관계를 갖는다.

- 본 방식을 통해 Model과 View가 다른 컴포넌트들에 종속되지 않아 변경에 유리하다.

### Model

- 애플리케이션의 정보, 데이터를 관리한다. : DB와 연동된다.
- 다음 규칙을 지켜야 한다.
    - 사용자가 편집하길 원하는 **모든 데이터**를 갖고 있어야 한다.
    - **View나 Controller에 대해 어떠한 정보도 알고 있으면 안된다.**
    - 변경이 일어나면, 변경 통지에 대한 처리 방법을 구현해야 한다.

### View

- 사용자와 마주하는 컴포넌트이다. : 사용자 인터페이스
- 데이터의 입출력을 담당한다.
- 다음 규칙을 지켜야 한다.
    - **모델이 갖고 있는 정보를 따로 저장하면 안된다.**
    - **Model이나 Controller에 대해 어떠한 정보도 알고 있으면 안된다.**
        - 데이터를 받으면 표시만 해주는 역할이다.
    - 변경이 일어나면, 변경 통지에 대한 처리 방법을 구현해야 한다.

### Controller

- View와 Model을 이어준다.
- 애플리케이션의 메인 로직이 구현된다.
- 사용자가 View에서 어떤 일을 했는지 파악하고, 그에 따라 Model을 통해 데이터를 받아와 로직을 수행하거나, 변경/삽입/삭제를 수행한다.
- 다음 규칙을 지켜야 한다.
    - Model이나 View에 대해 알고 있어야 한다.
    - Model과 View의 변경을 모니터링 해야 한다.



## MVC 패턴을 지키기 위한 방법

---

1. Model은 Controller와 View에 의존하지 않아야 한다.
    - **Model 내부에 Controller, View와 관련된 코드가 있으면 안된다.**
2. **View는 Model에만 의존**해야 하고, Controller에는 의존하면 안된다.
    - **View 내부에는 Model의 코드만 있을 수 있고, Controller의 코드가 있으면 안된다.**
        - Model의 내용을 출력하기 위해서는 Model 관련 코드는 있을 수 밖에 없다.
        - 하지만 Controller 관련 코드는 있으면 안된다.
3. View가 Model로부터 데이터를 받을 때는, **사용자마다 다르게 보여주어야 하는 데이터에 대해서만** 받아야 한다.
    - 모든 사용자가 **공통적으로 보는 내용(UI)**에 대해서는 **View가 자체적으로 갖고 있어야 한다.**
    - 사용자마다 다르게 보여줘야 하는 데이터(사용자 정보, 구매 내역 등)만 Model로부터 가져와야 한다.
4. Controller는 Model과 View에 의존해도 된다.
    - Controller 내부에는 Model과 View의 코드가 있어도 된다.
5. View가 Model로부터 데이터를 받을 때, 반드시 **Controller로부터** 받아야 한다.

<br>

---

<br>


### 출처

- [(블로그) MVC패턴 (Model, View, Controller)](https://velog.io/@whitecloud94/MVC-%ED%8C%A8%ED%84%B4-Model-View-Controller)
- [(블로그) 웹 MVC 각 컴포넌트 역할](https://tecoble.techcourse.co.kr/post/2021-04-26-mvc/)
- [(Youtube) [10분 테코톡] 제리의 MVC 패턴](https://www.youtube.com/watch?v=ogaXW6KPc8I)