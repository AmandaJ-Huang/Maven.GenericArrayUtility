package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] array;

    public ArrayUtility(T[] array) {
        this.array = array;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        Integer counter = 0;

        for (int i = 0; i < arrayToMerge.length; i++) {
            if(arrayToMerge[i].equals(valueToEvaluate)) {
                counter++;
            }
        }

        for (int i = 0; i < this.array.length; i++) {
            if(this.array[i].equals(valueToEvaluate)) {
                counter++;
            }
        }

        return counter;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        Integer counter = 0;
        T mostCommon = null;
        List<T> newArray = new ArrayList<>(Arrays.asList(array));
        newArray.addAll(Arrays.asList(arrayToMerge));

        for (T element : newArray) {
            if (getNumberOfOccurrences(element) > counter) {
                counter += getNumberOfOccurrences(element);
                mostCommon = element;
            }
        }

        return mostCommon;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer counter = 0;

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].equals(valueToEvaluate)) {
                counter++;
            }
        }
        return counter;
    }

    public T[] removeValue(T valueToRemove) {
        List<T> newArray = new ArrayList<>();

        for (int i = 0; i < this.array.length; i++) {
            if (!this.array[i].equals(valueToRemove)) {
                newArray.add(this.array[i]);
            }
        }

        return newArray.toArray(Arrays.copyOf(this.array, newArray.size()));
    }
}
