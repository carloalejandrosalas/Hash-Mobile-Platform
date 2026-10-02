# LEGACY Database (structure inferred from the project's SQL)

## Connection

```java
DriverManager.getConnection("jdbc:mysql://localhost/telefonos","root","root");
```

Database: `telefonos`

---

## Table: `usuario`

It is observed in several queries and updates.

### Inferred columns

```text
codigo
fecha_ingreso
estado
ciudad
localidad
nombre
telefono
correo
numero_gratis
numero_frecuente
plan
tipo_plan
```

### Insert used

```sql
INSERT INTO usuario(fecha_ingreso,estado,ciudad,localidad,nombre,telefono,correo,numero_gratis,numero_frecuente,plan,tipo_plan)VALUES(?,?,?,?,?,?,?,?,?,?,?)
```

### Selects used

```sql
SELECT * FROM usuario WHERE nombre LIKE '%valor%'
SELECT * FROM usuario WHERE nombre='nombre'
SELECT * FROM usuario WHERE telefono='telefono'
SELECT * FROM usuario WHERE ciudad LIKE '%ciudad%' AND fecha_ingreso LIKE '%fecha%'
SELECT * FROM usuario WHERE estado LIKE '%estado%' AND fecha_ingreso LIKE '%fecha%'
SELECT * FROM usuario WHERE fecha_ingreso LIKE '%fecha%'
SELECT * FROM usuario WHERE ciudad LIKE '%ciudad%'
SELECT * FROM usuario WHERE estado LIKE '%estado%'
SELECT * FROM usuario WHERE fecha_ingreso LIKE '%mes_general%'
SELECT * FROM usuario
SELECT * FROM usuario ORDER BY n_usuario DESC LIMIT 1
```

### Update used

```sql
UPDATE usuario SET nombre='valor',telefono='valor',numero_gratis='valor',numero_frecuente='valor',plan='valor',tipo_plan='valor' WHERE codigo='valor'
```

### Delete used

```sql
DELETE FROM usuario WHERE telefono='telefono'
DELETE FROM usuario WHERE nombre='nombre'
```

### Note

In `consultar.java`, the following appears:

```sql
ORDER BY n_usuario DESC LIMIT 1
```

This suggests that a column named `n_usuario` may exist in `usuario`, although it does not appear in the main visible insert statement.

---

## Table: `telefonos`

### Inferred columns

```text
compañia
telefono
verdadero
```

### Insert used

```sql
INSERT INTO telefonos(compañia,telefono,verdadero)VALUES(?,?,?)
```

### Selects used

```sql
SELECT * FROM telefonos WHERE telefono='telefono'
```

This is used to validate whether a number is registered and whether `verdadero` equals `SI`.

---

## Table: `usuarios`

### Inferred columns

```text
nick
password
tipousuario
```

### Select used

```sql
SELECT * FROM usuarios WHERE nick='usuario' && password='pass'
```

This is used to authenticate users and then compare `tipousuario` with:

```text
Administrador
Invitado
```

---

## Raw summary

```text
DB: telefonos

tables:
- usuario
- telefonos
- usuarios
```

No `CREATE TABLE` statements were found in the code; the structure above was inferred directly from the SQL executed by the application.
