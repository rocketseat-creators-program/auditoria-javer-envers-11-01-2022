docker run --name some-postgres  -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres


docker exec -it some-postgres /bin/bash

CREATE DATABASE envers WITH ENCODING 'UTF8';

CREATE DATABASE javers WITH ENCODING 'UTF8';