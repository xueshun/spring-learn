package com.xuesran.strategy;

import lombok.Data;

/**
 * @Title: CmdHeader
 * @Description: 指令头信息
 * @author DANTE FUNG
 * @date 2020/10/22 20:23
 */
@Data
public class CmdHeader {

	/**
	 * 版本号
	 */
	private String version;
	/**
	 * 跟踪ID
	 */
	private String traceId;

}
