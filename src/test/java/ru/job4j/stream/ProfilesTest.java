package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ProfilesTest {

    @Test
    public void collectTest() {
        List<Profile> data = new ArrayList<>();
        data.add(new Profile(new Address("Tashkent", "Chilanzor", 14, 41)));
        data.add(new Profile(new Address("Angren", "Almazor", 13, 31)));
        data.add(new Profile(new Address("Bukhara", "Sergeli", 15, 51)));
        data.add(new Profile(new Address("Fergana", "Yunusobod", 16, 61)));
        data.add(new Profile(new Address("Tashkent", "Chilanzor", 14, 41)));
        data.add(new Profile(new Address("Bukhara", "Sergeli", 15, 51)));
        Profiles profilesMethod = new Profiles();
        List<Address> result = profilesMethod.collect(data);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Angren", "Almazor", 13, 31));
        expected.add(new Address("Bukhara", "Sergeli", 15, 51));
        expected.add(new Address("Fergana", "Yunusobod", 16, 61));
        expected.add(new Address("Tashkent", "Chilanzor", 14, 41));
        Assert.assertEquals(result, expected);
    }
}
