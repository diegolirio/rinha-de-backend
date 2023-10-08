# Support


### Postgresql

```sh
# enter inside container
docker exec -it a05f6e728d85 bash

# access to postgresql
psql -U app -d rinhadb -W 
#psql -h localhost -p 5432 -U app rinhadb

# show databases
\l

# connect to database
\c rinhadb



```