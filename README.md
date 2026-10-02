# Hash Mobile Platform

## Local MySQL

Copy the root Compose environment example and start MySQL from the repository root:

```sh
cp .env.example .env
docker compose --env-file .env -f infra/docker-compose.yml up -d
```

The database is published on `localhost:3306`. The example credentials are for
local development only; change them before using this setup beyond a local
machine.

## API

Copy `apps/api/.env.example` to `apps/api/.env` and set the API secrets and
SMTP settings. Its JDBC settings match the local MySQL example above. Build the
API with Maven from the repository root:

```sh
cp apps/api/.env.example apps/api/.env
mvn -f apps/api/pom.xml compile
```
