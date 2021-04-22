package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new CreateItemAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new EditItemAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new DeleteItemAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0"}
        );
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        +  "0. Exit" + System.lineSeparator()
                        + "=== Have a nice day! :) ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item sofa = new Item("Sofa");
        tracker.add(sofa);
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new ShowAllItemsAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Show all items" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Show all items ====" + System.lineSeparator()
                + sofa + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Show all items" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Have a nice day! :) ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindItemByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item sofa = new Item("Sofa");
        tracker.add(sofa);
        Input in = new StubInput(
                new String[] {"0", sofa.getName(), "1"}
        );
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new FindItemByNameAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Find items by name" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Find items by name ====" + System.lineSeparator()
                + sofa + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find items by name" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Have a nice day! :) ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindItemByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item sofa = new Item("Sofa");
        tracker.add(sofa);
        Input in = new StubInput(
                new String[] {"0", String.valueOf(sofa.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new FindItemByIdAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Find item by id" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Find item by Id ====" + System.lineSeparator()
                + sofa + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find item by id" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Have a nice day! :) ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new ExitAction(out));
        Input in = new StubInput(
                new String[] {String.valueOf(actions.size() + 1), "0"}
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
                        + "Wrong input, you can select: 0 .. 0" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
                        + "=== Have a nice day! :) ===" + System.lineSeparator()
                )
        );
    }
}