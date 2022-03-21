**Directory**

**_Справочник с записями регионов страны._**

1) Entry(запись) имеет свойства: id - уникальный индетификатор записи,
name - полное наименование региона, shortName - сокращенное наименование региона. 

2) API:
   * GET http://localhost:8081/directory-api/entries - получение всех записей;
   * GET http://localhost:8081/directory-api/entries/{entryId} - получение записи по id;
   * GET http://localhost:8081/directory-api/entries/search?searchParam={searchParam} - поиск записи по части полного наименования;
   * POST http://localhost:8081/directory-api/entries - добавление новой записи:
     ```       
     Параметры:
     {
       "name": String, 
       "shortName": String     
     }
     Все поля обязательные!
     ``` 
   * PUT http://localhost:8081/directory-api/entries/{entryId} - изменеине полей записи:
     ```       
     Параметры:
     {
       "name": String, 
       "shortName": String     
     }
     Все поля обязательные!
     ``` 
   * DELETE http://localhost:8081/directory-api/entries/{entryId} - удаление записи по id;                    