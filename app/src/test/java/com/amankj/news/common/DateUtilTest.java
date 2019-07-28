package com.amankj.news.common;

import com.amankj.news.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DateUtilTest extends BaseTest {

    @Test
    public void formatUTCDateToLocalTest_withoutException() {
        String dateStr = "2019-07-28T14:03:05Z";

        String formatDateStr = DateUtil.formatUTCDateToLocal(dateStr, DateUtil.YYYY_MM_DD_T_HH_MM_SS_Z,
                DateUtil.MMM_DD_YYYY_HH_MM_A);

        assertEquals(formatDateStr, "Jul 28, 2019 07:33 PM");
    }

    @Test
    public void formatUTCDateToLocalTest_withException() {
        String dateStr = "2019-07-28 14:03:05Z";

        String formatDateStr = DateUtil.formatUTCDateToLocal(dateStr, DateUtil.YYYY_MM_DD_T_HH_MM_SS_Z,
                DateUtil.MMM_DD_YYYY_HH_MM_A);

        assertNull(formatDateStr);

    }
}
