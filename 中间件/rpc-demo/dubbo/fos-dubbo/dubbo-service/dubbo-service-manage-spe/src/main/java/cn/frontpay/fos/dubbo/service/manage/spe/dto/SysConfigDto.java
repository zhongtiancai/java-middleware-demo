package cn.frontpay.fos.dubbo.service.manage.spe.dto;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import cn.frontpay.fos.dubbo.service.base.dto.DtoBase;

public class SysConfigDto extends DtoBase {

	private static final long serialVersionUID = 6532672815818128284L;
	/**默认缓存有效时长60分钟*/
	public static final int DEFAULT_CACHE_TIMEOUT = 60;
	/**默认缓存有效时长时间单位*/
	public static final TimeUnit DEFAULT_CACHE_UNIT = TimeUnit.MINUTES;

	private String id;

	private String code;

	private String name;

	private String configValue;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private Boolean isDelete;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

}
