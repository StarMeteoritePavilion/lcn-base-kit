package io.github.lcn29.base.kit.bean.converter;

import io.github.lcn29.base.kit.utils.DateUtil;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.time.LocalDate;
import java.util.Date;

/**
 * <pre>
 * Date 和 LocalDate 互相转换器
 * </pre>
 *
 * @author lcn29
 * @date 2023-03-05 21:07
 */
public class LocalDate2DateBidirectionalConverter extends BidirectionalConverter<Date, LocalDate> {

    @Override
    public LocalDate convertTo(Date date, Type<LocalDate> type, MappingContext mappingContext) {
        return DateUtil.date2LocalDate(date);
    }

    @Override
    public Date convertFrom(LocalDate localDate, Type<Date> type, MappingContext mappingContext) {
        return DateUtil.localDate2Date(localDate);
    }
}
