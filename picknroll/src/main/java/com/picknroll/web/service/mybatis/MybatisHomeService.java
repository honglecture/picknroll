package com.picknroll.web.service.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picknroll.web.dao.MemberRoleDao;
import com.picknroll.web.entity.MemberRole;
import com.picknroll.web.service.HomeService;
import com.picknroll.web.util.ParameterUtil;

@Service
public class MybatisHomeService implements HomeService {

	@Autowired
	private MemberRoleDao memberRoleDao;

	@Override
	public String getDefaultRoleName(String memberId) {

		List<MemberRole> list = memberRoleDao.getList(ParameterUtil.mapping("memberId", memberId));
		String roleName = "ROLE_CLIENT";
		for (MemberRole role : list) {
			if (role.getDefaultRole())
				roleName = role.getRoleName();
		}
		return roleName;
	}

}