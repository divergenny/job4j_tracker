package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void whenNameIncrOrder() {
        Comparator<Job> nameIncrOrder = new JobIncrByName();
        int rsl = nameIncrOrder.compare(
                new Job("bbb", 62),
                new Job("aaa", 61)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenNameDecrOrder() {
        Comparator<Job> nameDecrOrder = new JobDecrByName();
        int rsl = nameDecrOrder.compare(
                new Job("bbb", 62),
                new Job("aaa", 61)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenPriorityIncrOrder() {
        Comparator<Job> priorityIncrOrder = new JobIncrByPriority();
        int rsl = priorityIncrOrder.compare(
                new Job("bbb", 62),
                new Job("aaa", 61)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenPriorityDecrOrder() {
        Comparator<Job> priorityDecrOrder = new JobDecrByPriority();
        int rsl = priorityDecrOrder.compare(
                new Job("bbb", 62),
                new Job("aaa", 61)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorIncrByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobIncrByName().thenComparing(new JobIncrByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("aaaaaaaaa", 2),
                new Job("aaaaaaaaa", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDecrByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDecrByName().thenComparing(new JobDecrByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}