package com.hotel.repository;

import com.hotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 房间数据访问层
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    /**
     * 根据房间号查询房间
     */
    Optional<Room> findByRoomNumber(String roomNumber);

    /**
     * 根据房间状态查询房间列表
     */
    List<Room> findByStatus(Integer status);

    /**
     * 根据房间类型查询房间列表
     */
    List<Room> findByRoomType(Integer roomType);

}
