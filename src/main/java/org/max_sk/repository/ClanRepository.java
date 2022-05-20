package org.max_sk.repository;

import org.max_sk.model.Clan;

import java.util.HashMap;
import java.util.Objects;

public final class ClanRepository {
    /*  Нет необходимости сохранять данные в БД, поэтому будем хранить в HashMap */
    private static final HashMap<Long, Clan> clanHashMap = new HashMap<>();

    public static HashMap<Long, Clan> getClanHashMap() {
        return clanHashMap;
    }

    public static boolean addClan(long id, Clan clan) {
        try {
            if (id <= 0 || clan == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException exception) {
            exception.printStackTrace();
            return false;
        }
        clanHashMap.put(id, clan);
        return clanHashMap.containsKey(id);
    }

    public static Clan getClan(Long id) {
        if (id <= 0) {
            return null;
        }
        return Objects.requireNonNull(clanHashMap.get(id));
    }
}
