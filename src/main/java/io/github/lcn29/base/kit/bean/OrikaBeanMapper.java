package io.github.lcn29.base.kit.bean;

import io.github.lcn29.base.kit.bean.converter.LocalDate2DateBidirectionalConverter;
import io.github.lcn29.base.kit.bean.converter.LocalDate2StringBidirectionalConverter;
import io.github.lcn29.base.kit.bean.converter.LocalDateTime2DateBidirectionalConverter;
import io.github.lcn29.base.kit.bean.converter.LocalDateTime2StringBidirectionalConverter;
import ma.glasnost.orika.Converter;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * OrikaBeanMapper 配置
 * </pre>
 *
 * @author lcn29
 * @date 2023-03-05 20:21
 */
public class OrikaBeanMapper extends ConfigurableMapper {

    /**
     * 临时存储 Mapper 集合
     */
    private final List<Mapper<?, ?>> mapperList = new ArrayList<>();

    /**
     * 临时存储 Convert 集合
     */
    private final List<Converter<?, ?>> converterList = new ArrayList<>();

    public OrikaBeanMapper() {
        super(false);
    }

    /**
     * 添加 mapper
     *
     * @param mapper 新增的 mapper
     */
    public <T, V> void addMapper(Mapper<T, V> mapper) {
        mapperList.add(mapper);
    }

    /**
     * 添加 converter
     *
     * @param converter 新增的 converter
     */
    public <T, V> void addConvert(Converter<T, V> converter) {
        converterList.add(converter);
    }

    /**
     * 开始初始化
     *
     * @param autoAddLocalDateStringConverter 是否主任 LocalDate/LocalDateTime 和字符串互转的转换器
     */
    public void startInit(boolean autoAddLocalDateStringConverter) {
        if (autoAddLocalDateStringConverter) {
            addConvert(new LocalDate2StringBidirectionalConverter());
            addConvert(new LocalDateTime2StringBidirectionalConverter());
            addConvert(new LocalDate2DateBidirectionalConverter());
            addConvert(new LocalDateTime2DateBidirectionalConverter());
        }
        this.init();
    }

    @Override
    protected void configure(MapperFactory factory) {

        for (Mapper<?, ?> mapper : mapperList) {
            factory.registerMapper(mapper);
        }
        mapperList.clear();

        for (Converter<?, ?> converter : converterList) {
            factory.getConverterFactory().registerConverter(converter);
        }
        converterList.clear();
    }
}

