package com.xuesran.services.hello.exception;

import com.xuesran.services.hello.common.utils.JsonUtil;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class BizException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 系统不舒服 */
	public static final BizException UNKONW_EXCEPTION = new BizException(99990001, "系统不舒服！");
	/** 参数校验失败 */
	public static final BizException PARAM_CHECK_EXCEPTION = new BizException(99990002, "参数校验失败");
	/** 包含非法字符 */
	public static final BizException ERROR_CHAR_EXCEPTION = new BizException(99990003, "包含非法字符");

	/** 内部服务调用异常 */
	public static final BizException FEIGN_CAUSE_EXCEPTION = new BizException(99990004, "系统不舒服！");

	/** 系统不舒服 */
	public static final BizException OBJECT_CONVER_EXCEPTION = new BizException(99990005, "数据异常！");

	private final String msg;
	private final int code;

	protected BizException(int code, String msg) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}

	public BizException fmt(Object... args) {
		String message = this.msg;
		if (args != null && args.length > 0) {
			 message = MessageFormat.format(message, args);
		}
		return new BizException(this.code, message);
	}

	public String getMsg() {
		return msg;
	}

	public int getCode() {
		return code;
	}

	/**
	 * 注意：请勿修改
	 *
	 * @return
	 */
	@Override
	public String toString() {
		Map<String, Object> map = new HashMap<>();
		map.put("className", BizException.class.getName());
		map.put("code", code);
		map.put("msg", msg);

		return JsonUtil.map2Json(map);
	}

}