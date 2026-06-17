package com.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 房间实体类
 */
@Entity
@Table(name = "room")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 房间号
     */
    @Column(unique = true, nullable = false)
    private String roomNumber;

    /**
     * 房间类型 (0-单人间, 1-双人间, 2-三人间, 3-豪华间)
     */
    private Integer roomType;

    /**
     * 房间名称
     */
    private String roomName;

    /**
     * 房间描述
     */
    @Column(columnDefinition = "TEXT")
    private String description;

    /**
     * 房间位置/楼层
     */
    private String location;

    /**
     * 床位数
     */
    private Integer bedCount;

    /**
     * 最大入住人数
     */
    private Integer maxGuests;

    /**
     * 房间面积(平方米)
     */
    private BigDecimal area;

    /**
     * 每晚价格
     */
    private BigDecimal price;

    /**
     * 房间设施 (JSON格式)
     */
    @Column(columnDefinition = "TEXT")
    private String facilities;

    /**
     * 房间状态 (0-维护中, 1-可用, 2-已预定)
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
