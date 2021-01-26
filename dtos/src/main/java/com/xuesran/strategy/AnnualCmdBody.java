package com.xuesran.strategy;

import lombok.Data;

import java.util.List;

/**
 * @Title: AnnualCmdBody
 * @Description: 年度排班指令体
 * @author DANTE FUNG
 * @date 2020/10/22 20:30
 */
@Data
public class AnnualCmdBody {

	/**
	 * 员工编号列表
	 */
	private List<String> employeeNoList;
	/**
	 * 生成排班开始时间
	 */
	private String startDateStr;
	/**
	 * 生成排班结束时间
	 */
	private String endDateStr;
}
