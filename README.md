# Проект по автоматизации тестирования UI для мобильного приложения [Wikipedia](https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk)

## Покрытый функционал
> Разработаны автотесты на <code>UI</code>.
- :white_check_mark: Отображение результатов поиска
- :white_check_mark: Проверка открытия настроек
- :white_check_mark: Проверка первых четырех экранов Getting Started
## Технологический стек

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Allure TestOps" src="images/logo/Allure_TestOps.svg">
<img width="6%" title="Rest Assured" src="images/logo/Rest-Assured.svg">
<img width="6%" title="Appium" src="images/logo/Appium.svg">
<img width="6%" title="BrowserStack" src="images/logo/Browserstack.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
<img width="6%" title="Jira" src="images/logo/Jira.svg">
</p>

> В данном проекте автотесты написаны на <code>Java</code> с использованием фреймворков <code>Selenide</code> и <code>Appium</code> для UI-тестов, и библиотеки <code>REST Assured</code> для отображения видео в отчете.
>
> <code>BrowserStack</code> выполняет запуск приложения на удаленном мобильном Android-устройстве.
>
> <code>Selenoid</code> выполняет запуск приложения на удаленном сервере в контейнерах <code>Docker</code>.
>
> <code>JUnit 5</code> используется для модульного тестирования
>
> <code>Gradle</code> используется для автоматизированной сборки проекта
>
> <code>Jenkins</code> выполняет запуск тестов
>
> <code>Allure Report</code> формирует отчет о запуске тестов
>
> Автотесты интегрируются с тест-менеджмент системой <code>Allure TestOps</code> и таск-трекер системой <code>Jira</code>
>
> В <code>Telegram</code> отправляются уведомления о пройденном прогоне с помощью библиотеки [allure-notifications](https://github.com/qa-guru/allure-notifications)

## Запуск тестов из терминала
### Локальный запуск тестов

```
gradle clean test
```

## <img width="4%" title="Jenkins" src="images/logo/Jenkins.svg"> Для запусков автотестов используется [Jenkins](https://jenkins.autotests.cloud/job/09-Ambidre-mobile_tests/)

![Jenkins](images/screens/jenkins.png)

## <img width="4%" title="Allure Report" src="images/logo/Allure_Report.svg"> Анализ результатов запусков в Jenkins через Allure Reports

### Главная страница Allure-отчета

![Jenkins_Allure_Reports](images/screens/allure_dashbord.png)

### Информация о тестовом прогоне в графическом виде

![Jenkins_Allure_Reports](images/screens/allure_graphs.png)

### Группировка тестов по проверяемому функционалу

![Jenkins_Allure_Reports](images/screens/allure_detailes.png)

## <img width="4%" title="Allure TestOps" src="images/logo/Allure_TestOps.svg"> Интеграция тестов c тест-менеджмент системой [Allure TestOps](https://allure.autotests.cloud/jobrun/9938)

### Основной дашборд

![Allure Overview Dashboard](images/screens/allure_overview_dashboard.png)

### Дашборд для отображения успешности и длительности тестов

![Allure Overview Dashboard](images/screens/allure_duration_and_success_rate_dashboard.png)

### Дашборд по стендам

![Allure Overview Dashboard](images/screens/allure_stands_dashboard.png)

### Дашборд по членам команды

![Allure Overview Dashboard](images/screens/allure_team_dashboard.png)

### Запуски тестов

![Allure Overview Dashboard](images/screens/allure_launches.png)

### Результаты запуска тестов

![Allure_Launches](images/screens/testops_detailes.png)

### Сгруппированные тест-кейсы по проверяемому функционалу

![Allure TestOps](images/screens/allure_testcases.png)

## <img width="4%" title="Jira" src="images/logo/Jira.svg"> Интеграция тестов c таск-трекер системой [Jira](https://jira.autotests.cloud/browse/HOMEWORK-336)

> Интеграция с <code>Jira</code> позволяет добавлять в задачи тест-кейсы, запуски и их результаты.

![Jira Issues](images/screens/jira_issues.png)

## <img width="4%" title="Telegram" src="images/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

> Реализована отправка уведомлений о прогоне с помощью бота в <code>Telegram</code>.

![Telegram Notifications](images/screens/telegram_notifications.png)

## <img width="4%" title="BrowserStack" src="images/logo/Browserstack.svg"> Пример запуска теста в [BrowserStack](https://www.browserstack.com/)

![BrowserStack Video](images/gif/wikipedia_video.gif)

## <img width="4%" title="Selenoid" src="images/logo/Selenoid.svg"> Пример запуска теста в Selenoid

![Selenoid Video](images/gif/selenoid_video.gif)
