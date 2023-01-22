package ru.netology.i18n;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;


class LocalizationServiceImplTest {
    @BeforeEach
    public void beforeTest() {
        System.out.println("Проверка перед тестом");
    }

    @Test
    public void returnText() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        Assertions.assertEquals("Добро пожаловать", localizationService.locale(Country.RUSSIA));
        Assertions.assertEquals("Welcome", localizationService.locale(Country.USA));
    }

    @AfterEach
    public void afterTest() {
        System.out.println("Проверка после теста");
    }
}