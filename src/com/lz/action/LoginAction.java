package com.lz.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.lz.domain.Users;
import com.lz.form.UserForm;
import com.lz.service.UserService;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;
		System.out.println("UserName:" + userForm.getUsername());
		UserService service = new UserService();
		Users users = new Users();
		users.setUser_id(users.getUser_id());
		users.setUsername(userForm.getUsername());
		users.setPassword(userForm.getPassword());
		users.setEmail(userForm.getEmail());
		users.setCreated_at(userForm.getCreated_at());
		if (service.checkUser(users)) {

			return mapping.findForward("success");
		} else {
			return mapping.findForward("error");
		}
	}

}
