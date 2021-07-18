package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ProfilesTest {

    @Test
    public void collect() {
        List<Profile> data = new ArrayList<>();
        data.add(new Profile(new Address("Tashkent", "Mirzo-Ulugbek", 12, 21)));
        data.add(new Profile(new Address("Tashkent", "Almazor", 13, 31)));
        data.add(new Profile(new Address("Tashkent", "Almazor", 13, 31)));
        data.add(new Profile(new Address("Tashkent", "Chilanzor", 14, 41)));
        Profiles profilesMethod = new Profiles();
        List<Address> result = profilesMethod.collect(data);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Tashkent", "Mirzo-Ulugbek", 12, 21));
        expected.add(new Address("Tashkent", "Almazor", 13, 31));
        expected.add(new Address("Tashkent", "Almazor", 13, 31));
        expected.add(new Address("Tashkent", "Chilanzor", 14, 41));
        Assert.assertEquals(result, expected);
    }
}
