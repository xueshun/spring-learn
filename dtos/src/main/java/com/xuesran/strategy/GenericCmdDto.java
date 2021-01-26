package com.xuesran.strategy;

import lombok.Data;

/**
 * @Title: GenericCmdDto
 * @Description: 通用调度器指令
 * @author DANTE FUNG
 * @date 2020/10/22 20:19
 */
@Data
public class GenericCmdDto<T> {

	/**
	 * 指令码
	 */
	private String cmd;
	/**
	 * 指令头
	 */
	private CmdHeader cmdHeader;
	/**
	 * 指令体
	 */
	private T cmdBody;
}
