package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StartUITest {

    /*@Test
    public void whenCreateItem() {
        String[] answers = {"Chair"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Chair");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item sofaTest = new Item("Sofa");
        tracker.add(sofaTest);
        String[] answers = {
                String.valueOf(sofaTest.getId()),
                "Chair"
        };
        StartUI.editItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(sofaTest.getId());
        assertThat(replaced.getName(), is("Chair"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item sofaTest = new Item("Sofa");
        tracker.add(sofaTest);
        Item chairTest = new Item("Chair");
        tracker.add(chairTest);
        String[] answers = {
                String.valueOf(chairTest.getId()),
        };
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item deleted = tracker.findById(chairTest.getId());
        assertNull(deleted);
    }*/
}