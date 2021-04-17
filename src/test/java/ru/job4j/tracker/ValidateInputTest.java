package ru.job4j.tracker;


import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidMoreInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "1", "1", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int[] selected = new int[4];
        for (int index = 0; index < 4; index++) {
          selected[index] = input.askInt("Enter menu:");
        }
        int[] expected = {1, 1, 1, 1};
        assertArrayEquals(selected, expected);
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"-1", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new CreateItemAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Add new Item" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "Wrong input, you can select: 0 .. "
                        + (actions.length - 1) + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Add new Item" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Have a nice day! :) ===" + System.lineSeparator()
        ));
    }
}