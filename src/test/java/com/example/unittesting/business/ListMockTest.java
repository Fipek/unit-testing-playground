package com.example.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    void size_basic() {
        when(mock.size()).thenReturn(5);

        assertEquals(5,mock.size());
    }

    @Test
    void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);

        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }

    @Test
    void returnWithParameters() {
        when(mock.get(0)).thenReturn("fipek");

        assertEquals("fipek",mock.get(0));
        assertEquals(null,mock.get(1));
    }

    @Test
    void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("fipek");

        assertEquals("fipek",mock.get(0));
        assertEquals("fipek",mock.get(1));
    }

    @Test
    void verificationBasics() {
        // SUT
        String value1 = mock.get(0);
        String value2 = mock.get(1);

       // Verify
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    void argumentCapturing() {
        // SUT
        mock.add("SomeString");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }

    @Test
    void multipleArgumentCapturing() {
        // SUT
        mock.add("SomeString1");
        mock.add("SomeString2");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();

        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    @Test
    void mocking() {
        ArrayList arrayListMock = mock(ArrayList.class);

        System.out.println(arrayListMock.get(0)); // null
        System.out.println(arrayListMock.size()); // 0
        arrayListMock.add("Test");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size()); // 0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); //5
    }

    @Test
    void spying() {
        //@Spy ile ger??ek obje gibi ??al??????r.
        ArrayList arrayListSpy = spy(ArrayList.class);

        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0)); // Test0
        System.out.println(arrayListSpy.size()); // 1
        arrayListSpy.add("Test");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size()); // 3

        when(arrayListSpy.size()).thenReturn(5);

        System.out.println(arrayListSpy.size()); // 5

        arrayListSpy.add("Test4");
        System.out.println(arrayListSpy.size()); // 5

        verify(arrayListSpy).add("Test4");
    }
}
