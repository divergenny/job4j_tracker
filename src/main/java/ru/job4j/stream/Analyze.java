package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    /**
     * flatMap() for converting to a stream of Subject objects;
     * MapPoint() for subsequent conversion to a list of grades for each subject;
     * average() for calculating the average score for the subject;
     * OrElse() to return the default value.
     * @param stream stream of Pupil class
     * @return -1 in case no subject to count, and result in case there are subjects.
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(subject -> subject.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(-1);
    }

    /**
     * flatMap() for converting to a stream of Subject objects;
     * MapPoint() for subsequent conversion to a list of grades for each subject;
     * average() for calculating the average score for the subject;
     * OrElse() to return the default value. the map() method for converting objects
     * of the Tuple class to a stream, inside the method we will create these objects
     * - the string new Tuple()will appear there;
     * in this case, the name of the current Pupil object will be passed to the
     * constructor as the first parameter - we use the corresponding getter;
     * the second parameter is the calculated average score-the calculation can
     * be performed in the same sequence as described for the averageScore method;
     * the last method will be collect(), with which we will collect
     * everything into a List collection.
     * @param stream stream of Pupil class
     * @return List of Tuple with name of student ans his average result.
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(),
                pupil.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .average().getAsDouble())).collect(Collectors.toList());
    }

    /**
     * flatMap() for converting to a stream of Subject objects;
     * the collect() method to which we pass the groupingBy ()
     * method (with at least two parameters) of the Collectors class.
     * I use LinkedHashMap::new, for sorting parameters in order as they have.
     * In this case, the map is assembled as follows: the key is the
     * name of the subject, the value is the average score in this subject for each student.
     * To calculate the average score, use the averagingDouble() method of the Collectors class;
     * after that, we disassemble the assembled map using entrySet()
     * and open the stream using stream();
     * we will convert the resulting stream using map() into a stream of
     * objects of the Tuple class, inside the method we will create these objects - the string
     * new Tuple()will appear there;
     * we will pass parameters to the constructor using the getKey() and getValue() methods
     * of the Entry interface;
     * the last method will be collect(), with which we will collect
     * everything into a List collection.
     * @param stream stream of Pupil class
     * @return List<Tuple> with first key, name of subject
     * and second with average value.
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * As a basis, we take the implementation of the averageScoreBySubject
     * method with the exception of the following features:
     * in this method, we calculate the total score, not the average-so
     * instead of average (), we need to use the sum()method;
     * the terminal operation will not be the collect () method,
     * but the use of the max () method, to which we will pass the comparator.
     * In this case, the comparator will determine the Tuple object, which will
     * have the maximum Score value;
     * OrElse() to return the default value.
     * @param stream stream of Pupil class
     * @return Tuple where key and value of the best student.
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(),
                pupil.getSubjects().stream()
                        .mapToInt(Subject::getScore).sum()))
                .max(Comparator.comparing(Tuple::getScore)).orElse(null);
    }

    /**
     * As a basis, we take the implementation of the averageScoreByPupil method
     * with the exception of the following features:
     * in this method, we calculate the total score, not the average-so instead
     * of averagingDouble (), we need to use the summingDouble () method;
     * the terminal operation will not be the collect () method, but the use of
     * the max () method, to which we will pass the comparator. In this case,
     * the comparator will determine the Tuple object, which will have the maximum Score value;
     * OrElse() to return the default value.
     * @param stream stream of Pupil class
     * @return null if no best subject or Tuple with best subject in value: Subject, Score
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .max(Comparator.comparing(Tuple::getScore)).orElse(null);
    }
}
