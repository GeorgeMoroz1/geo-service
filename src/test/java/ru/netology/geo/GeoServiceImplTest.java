package ru.netology.geo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

class GeoServiceImplTest {
    @BeforeEach
    public void beforeTest_geo() {
        System.out.println("Проверка перед тестом");
    }

    @AfterEach
    public void afterTest_geo() {
        System.out.println("Проверка после теста");
    }

    @Test
    public void initGeo() {
        GeoService geoService = new GeoServiceImpl();
        Assertions.assertEquals(RUSSIA, geoService.byIp("172.123.12.19").getCountry());
        Assertions.assertEquals(USA, geoService.byIp("96.44.183.149").getCountry());
    }
}