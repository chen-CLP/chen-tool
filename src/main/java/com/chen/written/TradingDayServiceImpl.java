package com.chen.written;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName: chen-tool
 * @Description: TODO
 * @Author: 陈亮平
 * @Date: 2021/4/4 17:16
 * @Version: v1.0
 */
public class TradingDayServiceImpl implements TradingDayService {
    /**
     * 股票交易日期记录
     */
    private List<LocalDate> stockDates = new ArrayList<>();

    TradingDayServiceImpl() {

    }

    TradingDayServiceImpl(String fileName) {
        initStockDates(fileName);
    }

    /**
     * 初始化交易日期
     *
     * @param fileName
     */
    public void initStockDates(String fileName) {
        try {
            FileInputStream stream = new FileInputStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            String data = "";
            while ((data = reader.readLine()) != null) {
                String[] str = data.split(",");
                for (String s : str) {
                    s = s.replace("\'", "");
                    s = s.trim();
                    this.stockDates.add(LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                }
            }
            this.stockDates.sort(LocalDate::compareTo);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isTradingDay(LocalDate date) {
        return binarySearch(stockDates, date) >= 0;
    }


    @Override
    public Optional<LocalDate> queryNextTradingDay(LocalDate date) {
        if (stockDates.isEmpty()) {
            return Optional.empty();
        }
        int index = binarySearchRight(stockDates, date);
        if (stockDates.get(index).compareTo(date) == 0) {
            return index + 1 < stockDates.size() ? Optional.of(stockDates.get(index + 1)) : Optional.empty();
        } else {
            return Optional.of(stockDates.get(index));
        }
    }

    @Override
    public List<LocalDate> queryBetween(LocalDate from, LocalDate to) {
        int left = binarySearchRight(stockDates, from);
        List<LocalDate> resList = new ArrayList<>();
        while (left < stockDates.size() && stockDates.get(left).compareTo(to) <= 0) {
            resList.add(stockDates.get(left++));
        }
        return resList;
    }

    @Override
    public Optional<LocalDate> queryFirstTradingDayOfMonth(LocalDate date) {
        if (stockDates.isEmpty()) {
            return Optional.empty();
        }
        int index = binarySearchRight(stockDates, LocalDate.of(date.getYear(), date.getMonthValue(), 1));
        if (stockDates.get(index).getMonthValue() > date.getMonthValue()) {
            return Optional.empty();
        }
        return Optional.of(stockDates.get(index));
    }

    /**
     * 二分查找
     *
     * @param stockDates
     * @param date
     * @return
     */
    private int binarySearch(List<LocalDate> stockDates, LocalDate date) {
        int low = 0;
        int high = stockDates.size() - 1;
        if (stockDates.get(low).compareTo(date) == 0) {
            return low;
        }
        if (stockDates.get(high).compareTo(date) == 0) {
            return high;
        }
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = stockDates.get(mid).compareTo(date);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    /**
     * 二分查找第一个大于等于的
     *
     * @param stockDates
     * @param date
     * @return
     */
    private int binarySearchRight(List<LocalDate> stockDates, LocalDate date) {
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("ss");
        int low = 0;
        int high = stockDates.size() - 1;
        if (stockDates.get(low).compareTo(date) == 0) {
            return low;
        }
        if (stockDates.get(high).compareTo(date) == 0) {
            return high;
        }
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = stockDates.get(mid).compareTo(date);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}
