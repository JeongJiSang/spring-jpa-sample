package com.jbground.web.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class AppCommonUtil {

	/**
	 * 클라이언트 실제 IP 구하기
	 * @param request
	 * @return
	 */
	public static String getClientIp(HttpServletRequest request) {
		String ip = request.getHeader("X-FORWARDED-FOR");		
		
		if(ip == null || ip.length() == 0) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0) {
			ip = request.getHeader("WL-Proxy-Client-IP");		// weblogic
		}
		if(ip == null || ip.length() == 0) {
			ip = request.getRemoteAddr();
		}
		
		return ip;
	}
	/**
	 * 브라우저정보 구하기
	 * @return
	 */
	public static String getBrowser(String userAgent) {

		if (userAgent != null && !userAgent.equals("")) {
			if (userAgent.contains("Edge")  ) {
				return "Edge";
			} else if (userAgent.contains("Trident") || userAgent.contains("MSIE")) {
				return "MSIE";
			} else if (userAgent.contains("Firefox")) {
				return "Firefox";
			} else if (userAgent.contains("Chrome")) {
				return "Chrome";
			} else if (userAgent.contains("Safari")) {
				return "Safari";
			} else if (userAgent.contains("Opera") || userAgent.contains("OPR")) {
				return "Opera";
			}
		}
		return "Other";
	}

	/**
	 * OS정보 구하기
	 * @return
	 */

	public static String getOs(String userAgent) {

		if (userAgent != null && !userAgent.equals("")) {
			if (userAgent.contains("linux") ) {
				return "linux";
			} else if (userAgent.contains("Macintosh")) {
				return "macintosh";
			} else if (userAgent.contains("Mac OS X")) {
				return "mac os x";
			} else if (userAgent.contains("Windows")) {
				return "windows";
			} else if (userAgent.contains("iPhone") || userAgent.contains("iPad")) {
				return "ios";
			} else if (userAgent.contains("Android")) {
				return "android";
			}
		}
		return "Other";
	}
	
	/**
	 * 태그 변환
	 * @param param
	 * @return
	 */
	public static String replaceTag(String param) {
		if(!StringUtils.isEmpty(param)) {
			param = param.replaceAll("\\r\\n", "");
			param = param.replaceAll("？", "");
			param = param.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
			param = param.replaceAll("<[^>]*>", "");
			
			// 닫히지 않는 태그로 인한 오류 방지
			param = param.replaceAll("<", "&lt;");
		}
		
		return param;
	}
	
}
