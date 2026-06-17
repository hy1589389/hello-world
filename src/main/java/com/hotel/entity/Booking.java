package com.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 预订实体类
 */
@Entity
@Table(name = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 预订号
     */
    @Column(unique = true, nullable = false)
    private String bookingNumber;

    /**
     * 用户ID
     */
    @Column(nullable = false)
    private Long userId;

    /**
     * 房间ID
     */
    @Column(nullable = false)
    private Long roomId;

    /**
     * 入住日期
     */
    @Column(nullable = false)
    private LocalDate checkInDate;

    /**
     * 退房日期
     */
    @Column(nullable = false)
    private LocalDate checkOutDate;

    /**
     * 入住人数
     */
    private Integer guestCount;

    /**
     * 入住人姓名
     */
    private String guestName;

    /**
     * 入住人电话
     */
    private String guestPhone;

    /**
     * 入住人邮箱
     */
    private String guestEmail;

    /**
     * 总价格
     */
    private BigDecimal totalPrice;

    /**
     * 预订状态 (0-待确认, 1-已确认, 2-已入住, 3-已退房, 4-已取消)
     */
    private Integer status;

    /**
     * 备注
     */
    @Column(columnDefinition = "TEXT")
    private String remarks;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
