package org.example;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookingManagerTest {

    private HotelDao hotelDaoMock;
    private BookingManager bookingManager;

    @Before
    public void setUp() throws SQLException {
        hotelDaoMock = mock(HotelDao.class);
        bookingManager = new BookingManager(hotelDaoMock);
        List<String> availableRooms = Arrays.asList("A", "B", "C");
        when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRooms);
    }
    @Test
    public void checkRoomAvailableTrue() throws SQLException {
        assertTrue(bookingManager.checkRoomAvailability("A"));
    }


    @Test
    public void checkRoomAvailableFalse() throws SQLException {
        assertFalse(bookingManager.checkRoomAvailability("D"));
    }


}