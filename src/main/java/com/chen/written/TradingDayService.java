package com.chen.written;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

interface TradingDayService {

    /**
     * 判断是否为交易日
     *
     * @param date
     * @return
     */
    boolean isTradingDay(LocalDate date);

    /**
     * 查询下一个交易日
     *
     * @param date
     * @return
     */
    Object queryNextTradingDay(LocalDate date);

    /**
     * 查询一段时间范围的交易日, 注意包括[from, to]
     *
     * @param from
     * @param to
     * @return
     */
    List<LocalDate> queryBetween(LocalDate from, LocalDate to);

    /**
     * 查询日期所属月份的第一个交易日
     *
     * @param date
     * @return
     */
    Optional<LocalDate> queryFirstTradingDayOfMonth(LocalDate date);
}
