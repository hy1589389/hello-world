package com.hotel.service;

import com.hotel.entity.Booking;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * 预订业务层接口
 */
public interface BookingService {

    /**
     * 创建预订
     */
    Booking createBooking(Booking booking);

    /**
     * 根据ID查询预订
     */
    Optional<Booking> getBookingById(Long id);

    /**
     * 根据预订号查询预订
     */
    Optional<Booking> getBookingByNumber(String bookingNumber);

    /**
     * 根据用户ID查询预订
     */
    List<Booking> getBookingsByUserId(Long userId);

    /**
     * 根据房间ID和日期查询预订
     */
    List<Booking> getBookingsByRoomAndDate(Long roomId, LocalDate checkInDate, LocalDate checkOutDate);

    /**
     * 检查房间在指定日期是否可用
     */
    Boolean isRoomAvailable(Long roomId, LocalDate checkInDate, LocalDate checkOutDate);

    /**
     * 更新预订
     */
    Booking updateBooking(Booking booking);

    /**
     * 取消预订
     */
    void cancelBooking(Long id);

    /**
     * 确认入住
     */
    void confirmCheckIn(Long id);

    /**
     * 确认退房
     */
    void confirmCheckOut(Long id);

}
