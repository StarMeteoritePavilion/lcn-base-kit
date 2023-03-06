package io.github.lcn29.base.kit.bean.converter;

import io.github.lcn29.base.kit.utils.DateUtil;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <pre>
 * Date 和 LocalDateTime 互相转换器
 * </pre>
 *
 * @author lcn29
 * @date 2023-03-05 21:07
 */
public class LocalDateTime2DateBidirectionalConverter extends BidirectionalConverter<Date, LocalDateTime> {

    @Override
    public LocalDateTime convertTo(Date date, Type<LocalDateTime> type, MappingContext mappingContext) {
        return DateUtil.date2LocalDateTime(date);
    }

    @Override
    public Date convertFrom(LocalDateTime localDateTime, Type<Date> type, MappingContext mappingContext) {
        return DateUtil.localDateTime2Date(localDateTime);
    }
}
