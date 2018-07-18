package cn.cat.task;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenInfo {
	// 存储token信息集合
	private static ConcurrentHashMap<String, Map<String, String>> tokenInfo = new ConcurrentHashMap<>();

	// 添加新的token信息,date是有效几个小时
	public void addToken(Integer id, String token, Integer hour) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.HOUR, hour);
		Map<String, String> map = new HashMap<>();
		map.put("token", token);
		map.put("expiry", ((Long) cal.getTimeInMillis()).toString());
		tokenInfo.put(id.toString(), map);
	}

	// token有效时长计算
	public void countTokenExpiry() {
		tokenInfo.forEach((k, v) -> {
			Long storeTime = Long.parseLong(v.get("expiry"));
			if (storeTime <= new Date().getTime()) {
				tokenInfo.remove(k);
			}
		});
	}

	// 判断token是否有效
	public Boolean isTokenExist(String token) {
		Collection<Map<String, String>> values = tokenInfo.values();
		for (Map<String, String> map : values) {
			if (map.containsValue(token))
				return true;
		}
		return false;
	}

	// 退出登录时移除token信息
	public void tokenRemove(String id) {
		tokenInfo.remove(id);
	}
}
