package com.qa.domain;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;


public class DeluxeScreenUnitTest {

    private Long deluxeScreenId = 1L;
    private DeluxeScreen testDeluxeScreen;
    private DeluxeScreen testDeluxeScreenWithId;

    private DeluxeScreen testOtherDeluxeScreen;
    private DeluxeScreen testOtherDeluxeScreenWithId;

    @Before
    public void setUp(){
        testDeluxeScreen = new DeluxeScreen(1L, 2L, 3L, 4.5, "six");
        testDeluxeScreenWithId = new DeluxeScreen(7L, 8L, 9L,10.11, "twelve");
        testDeluxeScreenWithId.setDeluxeScreeningId(deluxeScreenId);
        testOtherDeluxeScreen = new DeluxeScreen(1L, 2L, 3L, 4.5, "six");
        testOtherDeluxeScreenWithId = new DeluxeScreen(7L, 8L, 9L,10.11, "twelve");
        testOtherDeluxeScreenWithId.setDeluxeScreeningId(deluxeScreenId);
    }

    @Test
    public void gettersAndSettersTest(){
        assertNotNull(testDeluxeScreenWithId.getDeluxeScreeningId());
        assertNotNull(testDeluxeScreenWithId.getDeluxeFilmId());
        assertNotNull(testDeluxeScreenWithId.getDeluxeBookingId());
        assertNotNull(testDeluxeScreenWithId.getDeluxeScreeningTime());
        assertNotNull(testDeluxeScreenWithId.getDeluxeSeatsBooked());

        testDeluxeScreenWithId.setDeluxeScreeningId(null);
        assertNull(testDeluxeScreenWithId.getDeluxeScreeningId());
        testDeluxeScreenWithId.setDeluxeFilmId(null);
        assertNull(testDeluxeScreenWithId.getDeluxeFilmId());
        testDeluxeScreenWithId.setDeluxeBookingId(null);
        assertNull(testDeluxeScreenWithId.getDeluxeBookingId());
        testDeluxeScreenWithId.setDeluxeScreeningTime(null);
        assertNull(testDeluxeScreenWithId.getDeluxeScreeningTime());
        testDeluxeScreenWithId.setDeluxeSeatsBooked(null);
        assertNull(testDeluxeScreenWithId.getDeluxeSeatsBooked());
    }

    @Test
    public void equalsWithNull() {
        assertFalse(testDeluxeScreen.equals(null));
    }

    @Test
    public void equalsWithDifferentObject() {
        assertFalse(testDeluxeScreen.equals(new Object()));
    }

    @Test
    public void checkEquality() {
        assertTrue(testDeluxeScreen.equals(testDeluxeScreen));
    }

    @Test
    public void checkEqualityBetweenDifferentObjects() {
        assertTrue(testOtherDeluxeScreen.equals(testOtherDeluxeScreen));
    }

    @Test
    public void deluxeScreenIdNullButOtherRarityNotNull() {
        testDeluxeScreen.setDeluxeScreeningId(null);
        assertFalse(testDeluxeScreen.equals(testOtherDeluxeScreen));
    }

    @Test
    public void itemDeluxeScreenIdNotEqual() {
        testOtherDeluxeScreen.setDeluxeScreeningId(3L);
        assertFalse(testDeluxeScreen.equals(testOtherDeluxeScreen));
    }

    @Test
    public void checkEqualityBetweenDifferentObjectsNullDeluxeScreenId() {
        testDeluxeScreen.setDeluxeScreeningId(null);
        testOtherDeluxeScreen.setDeluxeScreeningId(null);
        assertTrue(testDeluxeScreen.equals(testOtherDeluxeScreen));
    }

//    @Ignore
//    @Test
//    public void nullDeluxeScreenId() {
//        testDeluxeScreenWithId.setDeluxeScreeningId(null);
//        assertFalse(testDeluxeScreen.equals(testOtherDeluxeScreen));
//    }

    @Test
    public void nullIdOnBoth() {
        testDeluxeScreenWithId.setDeluxeScreeningId(null);
        testOtherDeluxeScreenWithId.setDeluxeScreeningId(null);
        assertTrue(testDeluxeScreenWithId.equals(testOtherDeluxeScreenWithId));
    }

    @Test
    public void otherIdDifferent() {
        testOtherDeluxeScreenWithId.setDeluxeScreeningId(2L);
        assertFalse(testDeluxeScreenWithId.equals(testOtherDeluxeScreenWithId));
    }
///////////////////////////////////////////////////////////////////////////////////

    @Test
    public void nullDeluxeFilmId() {
        testDeluxeScreen.setDeluxeFilmId(null);
        assertFalse(testDeluxeScreen.equals(testOtherDeluxeScreen));
    }
    @Test
    public void nullDeluxeFilmIdOnBoth() {
        testDeluxeScreen.setDeluxeFilmId(null);
        testOtherDeluxeScreen.setDeluxeFilmId(null);
        assertTrue(testDeluxeScreen.equals(testOtherDeluxeScreen));
    }

    @Test
    public void otherDeluxeFilmIdDifferent() {
        testDeluxeScreen.setDeluxeFilmId(15L);
        assertFalse(testDeluxeScreen.equals(testOtherDeluxeScreen));
    }

///////////////////////////////////////////////////////////////////////////////////

    @Test
    public void nullDeluxeBookingId() {
        testDeluxeScreen.setDeluxeBookingId(null);
        assertFalse(testDeluxeScreen.equals(testOtherDeluxeScreen));
    }

    @Test
    public void nullDeluxeBookingIdOnBoth() {
        testDeluxeScreen.setDeluxeBookingId(null);
        testOtherDeluxeScreen.setDeluxeBookingId(null);
        assertTrue(testDeluxeScreen.equals(testOtherDeluxeScreen));
    }

    @Test
    public void otherDeluxeBookingIdDifferent() {
        testOtherDeluxeScreen.setDeluxeBookingId(20L);
        assertFalse(testDeluxeScreen.equals(testOtherDeluxeScreen));
    }

////////////////////////////////////////////////////////////////////////////////

    @Test
    public void nullDeluxeScreeningTime() {
        testDeluxeScreen.setDeluxeScreeningTime(null);
        assertFalse(testDeluxeScreen.equals(testOtherDeluxeScreen));
    }

    @Test
    public void nullDeluxeScreeningTimeOnBoth() {
        testDeluxeScreen.setDeluxeScreeningTime(null);
        testOtherDeluxeScreen.setDeluxeScreeningTime(null);
        assertTrue(testDeluxeScreen.equals(testOtherDeluxeScreen));
    }

    @Test
    public void otherDeluxeScreeningTimeDifferent() {
        testOtherDeluxeScreen.setDeluxeScreeningTime(50.5);
        assertFalse(testDeluxeScreen.equals(testOtherDeluxeScreen));
    }

////////////////////////////////////////////////////////////////////////////////

    @Test
    public void nullDeluxeSeatsBooked() {
        testDeluxeScreen.setDeluxeSeatsBooked(null);
        assertFalse(testDeluxeScreen.equals(testOtherDeluxeScreen));
    }

    @Test
    public void nullDeluxeSeatsBookedOnBoth() {
        testDeluxeScreen.setDeluxeSeatsBooked(null);
        testOtherDeluxeScreen.setDeluxeSeatsBooked(null);
        assertTrue(testDeluxeScreen.equals(testOtherDeluxeScreen));
    }

    @Test
    public void otherDeluxeSeatsBookedDifferent() {
        testOtherDeluxeScreen.setDeluxeSeatsBooked("fifty");
        assertFalse(testDeluxeScreen.equals(testOtherDeluxeScreen));
    }



    @Test
    public void constructorWithoutId() {
        DeluxeScreen simple = new DeluxeScreen(1L, 2L, 3.4, "five");
        assertNull(simple.getDeluxeScreeningId());
        assertNotNull(simple.getDeluxeFilmId());
        assertNotNull(simple.getDeluxeBookingId());
        assertNotNull(simple.getDeluxeScreeningTime());
        assertNotNull(simple.getDeluxeSeatsBooked());
    }

    @Test
    public void hashCodeTest() {
        assertEquals(testDeluxeScreen.hashCode(), testOtherDeluxeScreen.hashCode());
    }

    @Test
    public void hashCodeTestWithNull() {
        DeluxeScreen deluxeScreen = new DeluxeScreen();
        deluxeScreen.setDeluxeScreeningId(null);
        DeluxeScreen otherDeluxeScreen = new DeluxeScreen();
        otherDeluxeScreen.setDeluxeScreeningId(null);
        assertEquals(deluxeScreen.hashCode(), otherDeluxeScreen.hashCode());
    }



}
