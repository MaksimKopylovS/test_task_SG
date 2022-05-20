package org.max_sk.manager;

import org.max_sk.model.Clan;
import org.max_sk.repository.ClanRepository;

import java.util.Objects;

public class ClanManager {

    public static Clan getClan(long clanId){
        if (clanId <= 0){
            return null;
        }
        return ClanRepository.getClan(clanId);
    }

    public static boolean saveClan(long clanId, Clan clan){
        try {
            if (clanId <= 0 || clan == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException exception) {
            exception.printStackTrace();
            return false;
        }
        return ClanRepository.addClan(clanId, clan);
    }
    /*  Задание 1 - Добавление золота в клан
    *   синхронизация реализована в Clan.incGold
    *  */
    public static boolean addGoldToClan(long clanId, int gold){
        if (clanId <= 0 || gold <=0) {
            return false;
        }
        return Objects.requireNonNull(ClanRepository.getClan(clanId)).incGold(gold);
    }
    /*  Задание 1 - Уменьшение золота из клана
    *   синхронизация реализована в Clan.decrementGold
    *  */
    public static boolean decrementGoldToClan(long clanId, int gold){
        if (clanId <= 0 || gold <=0) {
            return false;
        }
        return Objects.requireNonNull(ClanRepository.getClan(clanId)).decrementGold(gold);
    }

}
