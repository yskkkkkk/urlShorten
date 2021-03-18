
# 과제 내용
--- 
URL을 입력받아 짧게 줄여주고, Shortening된 URL을 입력하면 원래 URL로 리다이렉트하는 URL Shortening Service 예) https://en.wikipedia.org/wiki/URL_shortening => http://localhost/JZfOQNro

* URL 입력폼 제공 및 결과 출력
* URL Shortening Key는 8 Character 이내로 생성되어야 합니다.
* 동일한 URL에 대한 요청은 동일한 Shortening Key로 응답해야 합니다.
* 동일한 URL에 대한 요청 수 정보를 가져야 한다(화면 제공 필수 아님)
* Shortening된 URL을 요청받으면 원래 URL로 리다이렉트 합니다.
* Database 사용은 필수 아님

다음의 경우 가산점이 부과됩니다.

* Unit test 및 Integration test 작성.
---

# 리눅스를 통한 설치/배포 작업 
---
테스트는 aws 프리티어를 사용하여 EC2로 우분투 설정에 맞춰서 진행하였습니다.
![image](https://user-images.githubusercontent.com/55343933/111430450-c1da5c00-873d-11eb-908f-d7dab9c1998b.png)

푸티젠을 이용하여 key를 생성하고 푸티를 통해 접속하였습니다. 
![image](https://user-images.githubusercontent.com/55343933/111430654-0108ad00-873e-11eb-93b7-74b149db2e9d.png)

해당 리눅스에 자바, 메이븐, 깃, mysql 등을 설치 하고 버전을 확인해 줍니다. 
![image](https://user-images.githubusercontent.com/55343933/111430873-5c3a9f80-873e-11eb-9259-c214c538957b.png)

(설치하는 일련의 과정에서 권한이 계속 필요하므로 sudo su 를 이용해 root 계정으로 바꿔주는 것이 편하다)

깃에서 
```git
git clone + [repository 주소]
```
 를 이용해 프로젝트를 가져오고 
 해당 repository로 위치를 바꾸고 빌드를 시작해줍니다. 

#### jsp를 지원하지 않는 jar로 배포하지 않고 war로 바꿔서 배포합니다.

메이븐 설정을 jar -> war 로 한뒤 ServletInitializer class 를 생성하여 war 에게 맞게 해줍니다.
war 는 tomcat을 통해 배포해야 하므로 리눅스에서 tomcat 8버전 또한 설치해줍니다. 


(1) 인라인 링크  

(2) 참조 링크  

[blog]: https://miniminis.github.io/2019/10/13/spring/springboot-deploy/

