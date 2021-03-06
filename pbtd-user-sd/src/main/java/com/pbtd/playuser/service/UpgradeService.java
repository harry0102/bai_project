package com.pbtd.playuser.service;

import com.pbtd.playuser.dto.UpgradeDTO;

public interface UpgradeService {
	/**
	 * 校验升级版本
	 * @param type
	 * @param version
	 * @return
	 */
	UpgradeDTO queryValidateVersion(Integer type,String version);
}
