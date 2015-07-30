package website.livemarketing.config;

import javax.servlet.ServletContext;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRegistration.Dynamic;  
  
import org.springframework.web.WebApplicationInitializer;  
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;  
import org.springframework.web.servlet.DispatcherServlet;  
  
public class WebInitializer implements WebApplicationInitializer {
	
	private static AnnotationConfigWebApplicationContext applicationContext;
	
	public static Object getBean(String name){
		return applicationContext.getBean(name);
	}
	

	public void onStartup(ServletContext servletContext) throws ServletException {  
          
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
        ctx.register(Config.class,HibernateConfiguration.class);  
//        ctx.refresh();
        applicationContext = ctx;
        ctx.setServletContext(servletContext);    
        
        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));  
        servlet.addMapping("/");  
        servlet.setLoadOnStartup(1);  
          
    }  

}
