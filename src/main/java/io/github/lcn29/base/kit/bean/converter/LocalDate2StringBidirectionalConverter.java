package io.github.lcn29.base.kit.bean.converter;

import io.github.lcn29.base.kit.utils.DateUtil;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.time.LocalDate;

/**
 * <pre>
 * 字符串和 LocalDateTime 互相转换器
 * </pre>
 *
 * @author lcn29
 * @date 2023-03-05 21:07
 */
public class LocalDate2StringBidirectionalConverter extends BidirectionalConverter<String, LocalDate> {

    @Override
    public LocalDate convertTo(String source, Type<LocalDate> type, MappingContext mappingContext) {
        return DateUtil.string2LocalDate(source);
    }

    @Override
    public String convertFrom(LocalDate localDate, Type<String> type, MappingContext mappingContext) {
        return DateUtil.localDate2String(localDate);
    }
}
