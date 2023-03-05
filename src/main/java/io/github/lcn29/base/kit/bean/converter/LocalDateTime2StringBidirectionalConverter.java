package io.github.lcn29.base.kit.bean.converter;

import io.github.lcn29.base.kit.utils.DateUtil;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.time.LocalDateTime;

/**
 * <pre>
 * 字符串和 LocalDateTime 互相转换器
 * </pre>
 *
 * @author lcn29
 * @date 2023-03-05 21:08
 */
public class LocalDateTime2StringBidirectionalConverter extends BidirectionalConverter<String, LocalDateTime> {

    @Override
    public LocalDateTime convertTo(String source, Type<LocalDateTime> type, MappingContext mappingContext) {
        return DateUtil.string2LocalDateTime(source);
    }

    @Override
    public String convertFrom(LocalDateTime localDateTime, Type<String> type, MappingContext mappingContext) {
        return DateUtil.localDateTime2String(localDateTime);
    }
}
