# Задание

Разработать API для работы с объектной моделью.
Объектная модель - цифровой "слепок" завода, иерархическая структура, описывающая различные объекты на заводе. Объектом может быть сам завод, его какое-то отделение, единица оборудования или датчик на нем. 
Между двумя объектами можно задать связь родитель-ребенок, например участок, находящийся в определенном цеху, будет дочерним по отношению к этому цеху. Другой пример - датчик является дочерним по отношению к оборудованию, на котором установлен. 

Объекты имеют имена, а так же могут иметь атрибуты - набор пар ключ-значение. Например, тип объекта (цех\участок\оборудование\датчик), какие-то метаданные (номер цеха\участка), тип датчика или единицы измерения этого датчика.

API должно позволять выполнять следующие действия:
- добавить\прочитать объект (опционально - еще изменить\удалить)
- добавить\прочитать атрибут объекта (опционально - еще изменить\удалить)
- выгрузить рекурсивно всю структуру начиная с конкретного объекта. то есть сам объект, его атрибуты, список дочерних объектов с их атрибутами и так далее

## Описание:

####Перед запуском приложения необходимо развернуть PostgresSQL внутри Docker контейнера:

```bash
docker run --name pgsql -e POSTGRES_PASSWORD=auth -d -p 6000:5432 postgres
```
После запуска приложения через liquibase будут созданы все необходимые таблицы.
В приложении созданы обьекты завод - factory, цех/участок - sector, оборудование - equipment, датчик - detector.
Между обьектами осуществлена связь один ко многим, запросить любой обьект с связью(рекурсивно) можно запросом:
```bash
curl  "http://localhost:8080/factory/1"
```
Добавить обьект можно запросом например:
```bash
curl -H "content-type:application/json" -X POST -d '{"name": "test", "idParent": 1, "attribute": "test"}'  "http://localhost:8080/sector"
```
Удалить обьект можно запросом например:
```bash
curl -H "content-type:application/json" -X DELETE  "http://localhost:8080/sector/4"
```