package org.max_sk.manager;

import org.max_sk.model.Track;
import org.max_sk.repository.TrackerRepository;

public class TrackerManager {

    /*  Задание 3.
     * Создаётся объект трекер, который хранит id-Клана id-Пользователя и сколько этот пользователь внёс золота,
     * далее все трекеры сохраняются в HashMap */
    public static void trackerClanGold(long clanId, long userId, int gold){
        if(clanId <= 0 || userId <=0 || gold <=0){
            return;
        }
        Track track = new Track(clanId, userId, gold);
        TrackerRepository.getTrackHashMap().put(track.getId(), track);
    }
}
