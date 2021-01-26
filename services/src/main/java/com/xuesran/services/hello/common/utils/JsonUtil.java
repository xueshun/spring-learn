package com.xuesran.services.hello.common.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xuesran.services.hello.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Map;

@Slf4j
public abstract class JsonUtil {

	private JsonUtil(){
		//default
	}
	private static final ObjectMapper objectMapper = new ObjectMapper();

	static {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
	}

	@SuppressWarnings("unchecked")
	public static final Map<String, Object> json2Map(String json) {
		if (json == null) {
			return null;
		}

		try {
			return objectMapper.readValue(json, Map.class);
		} catch (Exception e) {
			throw BizException.OBJECT_CONVER_EXCEPTION;
		}
	}

	public static String map2Json(Map<String,Object> map) {
		return obj2Json(map);
	}

	public static final <T> T json2Obj(String content, Class<T> clazz) {
		if (StringUtils.isEmpty(content)) {
			return null;
		}
		try {
			return objectMapper.readValue(content, clazz);
		} catch (Exception e) {
			throw BizException.OBJECT_CONVER_EXCEPTION;
		}
	}

	public static String obj2Json(Object obj) {
		if (obj == null) {
			return null;
		}
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw BizException.OBJECT_CONVER_EXCEPTION;
		}
	}


    /**
     * 反序列化复杂Collection如List<Bean>, 先使用函数createCollectionType构造类型,然后调用本函数.
     * @param jsonString
     * @param javaType
     * @return
     */
    public static <T> T fromJson(String jsonString, JavaType javaType) {
        try {
            return objectMapper.readValue(jsonString, javaType);
        } catch (Exception e) {
			throw BizException.OBJECT_CONVER_EXCEPTION;
        }
    }
}
