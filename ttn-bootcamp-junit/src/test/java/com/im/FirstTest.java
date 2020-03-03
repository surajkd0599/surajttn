package com.im;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FirstTest {
    static First first;

    @BeforeAll
    static void creationFirstClassObject() {
        first = new First();
    }

    @Nested
    class ToReplaceSubString{
        @Test
        void shouldReturnNewString_When_SubstringIsFound() {
            //given
            String mainString = "this is suraj dubey";
            String findstring = "dubey";
            String replacedString = "singh";
            String expectedString = "this is suraj singh";

            //when
            String calculateString = first.replaceSubString(mainString, findstring, replacedString);

            //then
            assertEquals(expectedString, calculateString);
        }

        @Test
        void shouldReturnOriginalString_When_SubstringIsNotFound() {
            //given
            String mainString = "this is suraj dubey";
            String findstring = "singh";
            String replacedString = "verma";
            String expectedString = "this is suraj dubey";

            //when
            String calculateString = first.replaceSubString(mainString, findstring, replacedString);

            //then
            assertEquals(expectedString, calculateString);

        }

        @Test
        void should_return_originalString_when_given_null()
        {
            String mainString = "this is suraj dubey";
            String findString = null;
            String replacedString = "qwe";
            String expected ="this is suraj dubey";

            //when
            String string = (first.replaceSubString(mainString,findString,replacedString));

            //then
            assertEquals(expected,string);
        }
        @Test
        void should_return_originalString_when_given_null1()
        {
            //given
            String mainString = "this is suraj dubey";
            String findString = "abc";
            String replacedString = null;
            String expected ="this is suraj dubey";

            //when
            String string = (first.replaceSubString(mainString,findString,replacedString));

            //then
            assertEquals(expected,string);
        }
    }

    @Nested
    class ToFilterElements{

        @Test
        void shouldReturnOddElementOnly_When_OddElementExist_AfterFilterEvenElement() {
            //given
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < 6; i++) {
                list.add(i);
            }
            List<Integer> expectedlist = new ArrayList<>();
            expectedlist.add(1);
            expectedlist.add(3);
            expectedlist.add(5);

            //when
            List calculatelist = first.filterEvenElements(list);

            //then
            assertEquals(expectedlist, calculatelist);

        }
    }

    @Nested
    class ToCalculateAverage
    {
        @Test
        void shouldThrowMessageInvalidInput_When_ListIsNotExist() {
            //given
            List<BigDecimal> list = null;
            //List<BigDecimal> list=new ArrayList<>();

            //when
            try {
                first.calculateAverage(list);
            }

            //then
            catch (RuntimeException r) {
                System.out.println(r);

            }
        }

        @Test
        void shouldThrowMessageInvalidInput_When_ListIsEmpty() {
            //given
            List<BigDecimal> list = new ArrayList<>();

            //when
            try {
                first.calculateAverage(list);
            }

            //then
            catch (RuntimeException r) {
                System.out.println(r);

            }
        }

        @Test
        void shouldReturnAveragevalue_When_ListContainsElement() {

            //given
            List<BigDecimal> list = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                list.add(new BigDecimal(1212121));
                list.add(new BigDecimal(1212121));
                list.add(new BigDecimal(1212121));
                list.add(new BigDecimal(1212121));
            }
            BigDecimal expectedaverage = new BigDecimal(1212121);

            //when
            BigDecimal calculateaverage = first.calculateAverage(list);

            //then
            assertEquals(expectedaverage, calculateaverage);
        }

    }

    @Nested
    class IsPalindrome{
        @Test
        void check_for_String_is_Palindrome(){
            //given
            String str = "madam";

            //when
            Boolean str1 = first.isPallindrome(str);

            //then
            assertTrue(str1);
        }

    }

}