package com.hanfei.file.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.hanfei.file.FileUser;

public class UserFileServiceImpl implements UserFileService{

	public List<FileUser> add() {
		List<FileUser>  list = new ArrayList<FileUser>();
		for(int i=0;i<100;i++) {
			FileUser user = new FileUser();
			user.setId(Long.valueOf(i));
			user.setUserName(Integer.valueOf(i+(i+1)*99).toString());
			user.setPassword(UUID.randomUUID().toString().substring(0, 5));
			user.setSign("我是第"+i+"个用户，我很高兴！");
			user.setBirthDay(new Date());
			user.setAge((i+1)*10+i);
			user.setSalary(Double.valueOf((i+1)*500));
			list.add(user);
		}
		return list;
	}

}
