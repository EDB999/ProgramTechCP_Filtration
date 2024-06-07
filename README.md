# Курсовой проект "Разработка веб-сервиса статистики мероприятий"
----------------
**Описание**:

Проект "Разработка веб-сервиса статистики мероприятий" на Spring Boot направлен на создание инструмента для удобного ведения и безопасного хранения статиски данных о мероприятиях. Данный сервис за просмотр и считывание данных проведённых встреч, по которым рассчитана статистика в процентах.

**Скриншот сервиса обсулживания - Postman, отвечающего за интерфейс приложения**:
![image](https://github.com/EDB999/ProgramTechCP_Filtration/assets/113853336/7f2cb0ce-7728-4b2f-a8d3-e0126f683341)

## Модель данных в виде диаграммы классов.

На диаграмме представлена модель данных.

![image](https://github.com/EDB999/ProgramTechCP_Filtration/assets/113853336/97e6cfb4-bc24-49f8-b943-52997ebfef50)

## Диаграмма пакетов.

Основные пакеты, содержащие классы представлены на данной диаграмме.

![diagram-17515144307197406813](https://github.com/EDB999/ProgramTechCP_Filtration/assets/113853336/b0b2eb50-fe75-4a3d-928f-b37923f56b0c)

## Зависимости

Зависимости, которые должны быть установлены для работы этого программного обеспечения:
1. Язык программирования: Java
2. Фреймворк: Spring Boot (рекомендуемая версия, совместимая с вашей версией Java)
3. База данных: PostgreSQL
4. СУБД: DBeaver


## Описание API

Описание API микросервиса «Разработка веб-сервиса статистики мероприятий»

Основная информация 
|    Описание   |    Значение   |
| ------------- | ------------- |
| Роль в системе  | Микросервис для просмотра данных и расчёта статистики мероприятий, по критерию поиска.|
| Задача  | Обеспечить расчёт статистики в процентах, которая будет выводиться в формате отфильтрованных списков и таблиц мероприятий, по критериям поиска. |
| Сценарий  | Администратор может запрашивать статистику, рассчитанную в процентах из таблицы мероприятий по заданным критериям поиска. |


