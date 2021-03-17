# urlShorten

# 리눅스를 통한 설치/배포 작업 

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


![image](https://user-images.githubusercontent.com/55343933/111430528-d9194980-873d-11eb-9dbe-bfe2857a1aa7.png)

이후 빌드를 하게 되면 
해당 화면과 함께 jar 파일이 생성됩니다. 


해당 파일이 디렉터리로 위치를 이동하고 명령어를 이용해 배포해줍니다
![image](https://user-images.githubusercontent.com/55343933/111431010-90ae5b80-873e-11eb-87fb-7941b96eb342.png)

![image](https://user-images.githubusercontent.com/55343933/111431157-c2bfbd80-873e-11eb-8feb-67a5d40ba863.png)

시작 하는 것을 확인할 수 있습니다. 


(1) 인라인 링크  

(2) 참조 링크  

[blog]: https://miniminis.github.io/2019/10/13/spring/springboot-deploy/

