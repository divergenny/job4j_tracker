package ru.job4j.lambda;

import javax.print.attribute.standard.JobKOctets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13),
                new Attachment("image 0", 23)
        );
        Comparator comparator =  new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return left.getSize() - right.getSize();
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        Comparator sortByName = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                String leftS = left.getName();
                String rightS = right.getName();
                int result = 0;
                int length = Math.min(leftS.length(), rightS.length());
                for (int index = 0; index < length; index++) {
                    result = Character.compare(leftS.charAt(index), rightS.charAt(index));
                    if (result != 0) {
                        break;
                    }
                }
                return result == 0 ? Integer.compare(leftS.length(), rightS.length()) : result;
            }
        };
        attachments.sort(sortByName);
        System.out.println(attachments);
    }
}
