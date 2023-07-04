# 도커 연습하기
# 1. postgresql 이미지로 docker 컨테이너를 실행하고 volume을 연결.

docker create volume postgres-v #볼륨 생성
docker container run -v postgres-v:/var/lib/postgresql/data --name my_postgres_v -e POSTGRES_PASSWORD=1234 -p 5432:5432 -d postgres #컨테이너 실행

docker exec -it my_postgres_v bin/bash # 컨테이너 내부 접속

psql -U postgres # psql 접속

#더미 데이터 생성
#CREATE TABLE users (
#    id serial PRIMARY KEY,
#    name text,
#    email text
#);
#INSERT INTO users (name, email) VALUES ('John Doe', 'johndoe@example.com');


#위 데이터 넣고 컨테이터 삭제 후 다시 컨테이너 실행해서 데이터 유지되는지 검증
#위 run 명령어 아래 동일하게 실행하기.



