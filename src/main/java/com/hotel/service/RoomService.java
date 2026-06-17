package com.hotel.service;

import com.hotel.entity.Room;

import java.util.List;
import java.util.Optional;

/**
 * 房间业务层接口
 */
public interface RoomService {

    /**
     * 创建房间
     */
    Room createRoom(Room room);

    /**
     * 根据ID查询房间
     */
    Optional<Room> getRoomById(Long id);

    /**
     * 根据房间号查询房间
     */
    Optional<Room> getRoomByNumber(String roomNumber);

    /**
     * 查询所有可用房间
     */
    List<Room> getAvailableRooms();

    /**
     * 根据房间类型查询房间
     */
    List<Room> getRoomsByType(Integer roomType);

    /**
     * 更新房间信息
     */
    Room updateRoom(Room room);

    /**
     * 删除房间
     */
    void deleteRoom(Long id);

    /**
     * 更新房间状态
     */
    void updateRoomStatus(Long id, Integer status);

}
