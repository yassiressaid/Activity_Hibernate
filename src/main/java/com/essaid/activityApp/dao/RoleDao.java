package com.essaid.activityApp.dao;

import java.sql.SQLException;
import java.util.List;

import com.essaid.activityApp.models.Role;

public interface RoleDao {

	public void addRole(Role role) throws ClassNotFoundException, SQLException;

	public void updateRole(Role role) throws ClassNotFoundException, SQLException;

	public List<Role> listRoles() throws ClassNotFoundException, SQLException;

	public Role getRoleById(Long id) throws ClassNotFoundException, SQLException;

	public void removeRole(Long id) throws ClassNotFoundException, SQLException;
}
