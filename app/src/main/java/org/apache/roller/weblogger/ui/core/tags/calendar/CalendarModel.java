/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  The ASF licenses this file to You
 * under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.  For additional information regarding
 * copyright in this work, please see the NOTICE file in the top level
 * directory of this distribution.
 */

package org.apache.roller.weblogger.ui.core.tags.calendar;
import java.util.Calendar;
import java.util.Date;

/**
 * Model interface for the CalendarTag. The CalendarTag will set a day,
 * then use the computeUrl method to get the URLs it needs.
 */
public interface CalendarModel {
    Calendar getCalendar();
    
    void setDay( String month ) throws Exception;
    
    Date getDay();
    
    Date getNextMonth();

    Date getPrevMonth();
    
    String computePrevMonthUrl();
    
    String computeTodayMonthUrl();
    
    String computeNextMonthUrl();

    /**
     * Get the earliest month in which there could possibly be data.  For a weblog this
     * is the beginning of the month containing the creation date.
     */
    //public Date getInitialMonth();
    
    /**
     * Create URL for use on edit-weblog page, preserves the request
     * parameters used by the tabbed-menu tag for navigation.
     *
     * @param day      Day for URL
     * @param monthURL True to return month URL (6-char date)
     * @param valid    Always return a URL, never return null
     * @return         URL for day, or null if no weblog entry on that day
     */
    String computeUrl( java.util.Date day, boolean monthURL, boolean valid );
    
    /**
     * Get calendar cell content or null if none.
     *
     * @param day Day for URL
     * @param valid Always return a URL, never return null
     * @return Calendar cell content or null if none.
     */
    String getContent( java.util.Date day );
}

