✏reservation-service
========================

## 📌웹 프론트엔드 기술요구 사항
* DOMContentloaded 이후에 모든 자바스크립트 로직이 동작하게 합니다.
* 상단영역의 애니메이션은 CSS3의 transition과 transform 속성을 활용해서 구현해야 합니다.
* TABUI로 구성되는 카테고리 아이템이 노출되는 영역의 HTML은 카테고리별로 각각 만들지 않고 하나로 만들어 재사용합니다.
* 카테고리 탭을 선택할 때마다, Ajax 요청을 해서 데이터를 가져와야 합니다.
* 탭 메뉴 (전시/뮤지컬/콘서트 등)는 Event delegation으로 구현합니다.
* Template 코드를 javascript 함수 안에 보관하지 않고, 별도 분리시켜서 사용해야 합니다. (HTML에 script태그 안에 보관한다던가)
* 함수 하나에 여러 개의 기능을 넣지 않고, 함수를 여러 개로 분리합니다.

## 📌웹 벡엔드 기술요구 사항
* 제공된 SQL을 이용해서 테이블을 생성하고, 샘플데이터를 입력합니다.
* maven을 이용해서 웹 어플리케이션 프로젝트를 작성합니다.
* 학습했던 것처럼 controller,service,dao로 레이어드 아키텍쳐를 구성합니다.
* spring JDBC를 이용하여 주어진 테이블로부터 입력, 수정, 삭제, 조회하는 DAO와 DTO를 작성합니다.
* 서비스 인터페이스를 작성하고 해당 서비스 인터페이스에 비지니스 메소드를 작성합니다.
* 서비스 인터페이스를 구현하는 클래스를 작성합니다.
* 해당 구현 클래스의 메소드에 적절한 트랜잭션에 관련된 애노테이션을 사용합니다.
* 클라이언트에게 Web API를 제공하기 위해 RestController 를 작성합니다.

## ▶개발과정 참고

### 1. maven 프로젝트를 생성합니다.
groupId 와 artifactId 는 임의로 지정합니다.
### 2. MySQL 에서 프로젝트에 사용할 database 와 사용자 계정을 생성합니다.
생성한 데이터베이스와 계정정보는 src/main/resources/application.properties 파일에 다음과 같이 설정합니다.
```properties
spring.datasource.driver-class-name=com.mysql.jdbc.Driver 
spring.datasource.url=jdbc:mysql://domain:port/dbName?useUnicode=true&characterEncoding=utf8 
spring.datasource.username=dbUserName
spring.datasource.password=dbPasswd
```
### 3. 프로젝트 루트 폴더에 .gitignore파일을 생성합니다.
해당 파일에는 다음의 내용을 입력합니다.
```gitignore
target
.classpath
.project
.settings
```
### 4. 생성한 데이터베이스에 접속하여 주어진 sql을 실행합니다.
먼저 ddl.sql의 내용을 실행하여 테이블을 생성하고, dml.sql의 내용을 실행하여 샘플 데이터를 추가합니다.
<div align = "center">
 
 ![reservation-erd1](https://user-images.githubusercontent.com/48908552/160737875-dccf804a-b6bb-45ee-aac0-44e8bbd43925.png)   
   _ERD_
 
</div>

### 5. sample이미지가 있는 압축파일인 img.zip을 webapp 폴더에 압축 해제합니다.
webapp폴더에 img와 img_map 폴더 아래에 샘플 이미지가 위치합니다.
### 6. Spring MVC, Spring JDBC를 사용하기 위한 Spring설정 파일들을 작성합니다.
### 7. 샘플 데이터를 읽어 들여 메인화면을 출력하기 위한 DTO, Controller, Service, Repository를 알맞게 작성합니다.



## 💻실행화면




