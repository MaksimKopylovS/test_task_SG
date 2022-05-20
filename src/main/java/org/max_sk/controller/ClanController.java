package org.max_sk.controller;

import org.max_sk.manager.ClanManager;
import org.max_sk.model.Clan;
import org.max_sk.manager.TrackerManager;

import java.util.Objects;

public class ClanController {

    public void incGold(long clanId, int gold) {
        try {
            if (clanId <= 0 || gold <= 0) {
                throw new NullPointerException();
            }
        } catch (NullPointerException exception) {
            exception.printStackTrace();
            return;
        }
        Clan clan = Objects.requireNonNull(ClanManager.getClan(clanId));
        clan.incGold(gold);
    }
    /*  Задание 3
     *  В задание указанно сделать реализацию:
     *
     *  Clan clan = ClanManager.getClan(clanId);
     *  clan.incGold(gold);
     *  TrackerManager.trackGold(clanId, userId, gold);
     *
     *  Можно выполнить обращение непосредственно к менеджеру (как в паттерне MVC)
     *  ClanManager.addGoldToClan(clanId, gold);
     *  и если addGoldToClan вернёт true записывать информацию в TrackerManager
     *  в таком случае мы будем уверены, что данные успешно обработаны.
     *  */

    public void incGold(long clanId, int gold, int userId) {
        try {
            if (clanId <= 0 || gold <= 0 || userId <=0) {
                throw new NullPointerException();
            }
        } catch (NullPointerException exception) {
            exception.printStackTrace();
            return;
        }

        Clan clan = Objects.requireNonNull(ClanManager.getClan(clanId));
        clan.incGold(gold);
        TrackerManager.trackerClanGold(clanId, userId, gold);
    }
}
