package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        Citizen result = null;
        for (String key : citizens.keySet()) {
            Citizen citizen = citizens.get(key);
            if (passport.equals(citizen.getPassport())) {
                result = citizen;
            }
        }
        return result;
    }
}
