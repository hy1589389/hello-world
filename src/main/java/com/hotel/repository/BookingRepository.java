package com.hotel.repository;

import com.hotel.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * 预订数据访问层
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    /**
     * 根据预订号查询预订
     */
    Optional<Booking> findByBookingNumber(String bookingNumber);

    /**
     * 根据用户ID查询预订列表
     */
    List<Booking> findByUserId(Long userId);

    /**
     * 根据房间ID和日期范围查询预订
     */
    List<Booking> findByRoomIdAndCheckInDateLessThanEqualAndCheckOutDateGreaterThanEqual(
            Long roomId, LocalDate checkOutDate, LocalDate checkInDate);

    /**
     * 根据预订状态查询预订列表
     */
    List<Booking> findByStatus(Integer status);

}
