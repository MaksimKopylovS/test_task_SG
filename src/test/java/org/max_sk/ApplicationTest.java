package org.max_sk;

import org.junit.jupiter.api.Test;
import org.max_sk.controller.ClanController;
import org.max_sk.model.Clan;
import org.max_sk.repository.ClanRepository;
import org.max_sk.repository.TrackerRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {

    private static final int QUANTITY_TREAD = 1500;

    @Test
    public void clanControllerTest() {

        /*  Создание 10 тестовых кланов */
        Clan clan;
        for (int i = 1; i < 11; i++) {
            clan = new Clan("Клан " + i);
            ClanRepository.getClanHashMap().put(clan.getIdClan(), clan);
        }
        /*  Выводим созданные Кланы на экран */
        ClanRepository.getClanHashMap().forEach((k, v) -> System.out.println(k + "=" + v.toString()));


        ClanController clanController = new ClanController();

        /* Решение Задания 1 + Задания 2.
         * Добавления золота в Клан в многопоточное режиме создавая 1500 потоков  */
        for (int i = 0; i < QUANTITY_TREAD; i++) {
            new Thread(() ->
                    clanController.incGold(1, 1, 1 + (int) (Math.random() * 100))
            ).start();
        }

        System.out.println();

        /*  Останавливаем основной поток на 1 секунду для того чтобы сгенерированные потоки успели закончить работу */
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*  Вывод значений */
        ClanRepository.getClanHashMap().forEach((k, v) -> System.out.println(k + "=" + v.toString()));

        /* Проверка, значение всегда должно быть 1500 */
        assertEquals(1500, ClanRepository.getClanHashMap().get(1L).getGold());

        /*  Задание 3
        * Проверка работы TrackManager
        * */
        System.out.println();
        TrackerRepository.getTrackHashMap().forEach((k, v) -> System.out.println(k + "=" + v.toString()));
    }

}
