# catalog-service

Catalog service application is a distributed microservice architecture deployed on Kubernetes.

<hr/><hr/>
<b>Notes on the project</b>

1. Refresh service configuration by enabling actuator in application.yml then calling <i>http POST <service_url>/actuator/refresh</i>
2. Run a Postgres SQL server on Docker:

 a. Create network: docker create network catalog-network;
 
 b. Create Postgres container:

	docker run -d \
	--name polar-postgres \
	--net catalog-network \
	-v ~/postgress:/var/lib/postgresql/data \
	-e POSTGRES_USER=postgres \
	-e POSTGRES_PASSWORD=password \
	-e POSTGRES_DB=polardb_catalog \
	-p 5432:5432 \
	postgres:latest
	
	Then get container ID by running <i>docker ps</i> and connect inside the container with <i>docker exec -it <container_id> bash</i>
	
		root@05b3a3471f6f:/# psql -U postgres
		postgres-# \l
	
	From outside container, connect to server <i>psql -h <public-ip-server> -p 5432 -U postgres</i>, provide password and list databases <i>postgres=# \l</i>
	
  c. Create catalog-service Docker container image:
  
  	docker  build -t catalog-service .
  	
  d. Run container:
  
  	
	docker run -d \
	--name catalog-service \
	--net catalog-network \
	-e SPRING_DATASOURCE_URL=jdbc:postgresql://polar-postgres:5432/polardb_catalog \
	-e SPRING_PROFILES_ACTIVE=testdata \
	-p 9001:9001 \
	catalog-service

   e. Remove PostgreSQL and Catalog Service containers:	
	
	docker rm -vf catalog-service polar-postgres


			   	
  	