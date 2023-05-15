# catalog-service

Catalog service application is a distributed microservice architecture deployed on Kubernetes.

<hr/><hr/>
<b>Notes on the project</b>

1. Refresh service configuration by enabling actuator in application.yml then calling <i>http POST <service_url>/actuator/refresh</i>
2. Run a Postgres SQL server on Docker:

	docker run -d \
	--name polar-postgres \
	-e POSTGRES_USER=user \
	-e POSTGRES_PASSWORD=password \
	-e POSTGRES_DB=polardb_catalog \
	-p 5432:5432 \
	postgres:15.3
	
	Then get container ID by running <i>docker ps</i> and connect inside the container with <i>docker exec -it <container_id> bash</i>
	
		root@05b3a3471f6f:/# psql -U postgres
		postgres-# \l
	
	From outside container, connect to server <i>psql -h <public-ip-server> -p 5432 -U postgres</i>, provide password and list databases <i>postgres=# \l</i>