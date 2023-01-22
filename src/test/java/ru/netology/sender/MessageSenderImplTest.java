package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;


class MessageSenderImplTest {
    GeoService geoService;
    LocalizationService localizationService;
    MessageSender messageSender;

    @BeforeEach
    public void init() {
        geoService = Mockito.mock(GeoServiceImpl.class);
        localizationService = Mockito.mock(LocalizationServiceImpl.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    public void isRussian() {
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        Mockito.when(geoService.byIp("172.123.12.19"))
                .thenReturn(new Location("MOSCOW", RUSSIA, null, 0));

        Mockito.when(localizationService.locale(RUSSIA)).thenReturn("Добро пожаловать");
        Assertions.assertEquals("Добро пожаловать", messageSender.send(headers));
    }

    @Test
    public void isAmerican() {
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.58.780.179");
        Mockito.when(geoService.byIp("96.58.780.179"))
                .thenReturn(new Location("New York", Country.USA, null, 0));

        Mockito.when(localizationService.locale(USA)).thenReturn("Welcome");
        Assertions.assertEquals("Welcome", messageSender.send(headers));
    }
}