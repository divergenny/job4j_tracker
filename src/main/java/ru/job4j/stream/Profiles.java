package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        List<Address> addresses = profiles.stream()
                .map(profile -> profile.getAddress())
                .collect(Collectors.toList());
        return addresses;
    }
}
