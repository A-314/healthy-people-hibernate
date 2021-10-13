/*   Copyright 2014, Tzu-Cheng Chuang (http://chuangtc.com) 
 *   Licensed under the MIT license. http://opensource.org/licenses/MIT
 */
package com.emelian.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[0];
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{SpringConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	@Override
	public void onStartup(ServletContext aServletContext) throws ServletException {
		super.onStartup(aServletContext);
	}

}