package com.prometheus.filters;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class VlastnyFilter extends Filter<ILoggingEvent> {

    String levelElement;

    public String getLevelElement() {
        return levelElement;
    }

    public void setLevelElement(String levelElement) {
        this.levelElement = levelElement;
    }

//    @Override
////    public FilterReply decide(ILoggingEvent iLoggingEvent) {
////        if (iLoggingEvent.getLevel().levelInt == Level.ERROR_INT
////                && iLoggingEvent.getMessage().contains("prometheus.com")){
////                return FilterReply.NEUTRAL;
////        }
////        return FilterReply.DENY;
////    }


    @Override
    public FilterReply decide(ILoggingEvent iLoggingEvent) {
        if (iLoggingEvent.getLevel().levelStr.equalsIgnoreCase(levelElement)
                && iLoggingEvent.getMessage().contains("prometheus.com")){
            return FilterReply.NEUTRAL;
        }
        return FilterReply.DENY;
    }
}
