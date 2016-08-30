package com.yufeng.blog.utils;

import javax.faces.context.FacesContext;

public class GetServerLocation {
	public static String getServerLocation(){
		return FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
	}
}
