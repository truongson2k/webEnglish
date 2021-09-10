package DB;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

	public class Logger implements Filter {
		 
	    private String encoding;
	 
	    public void init1(FilterConfig config) throws ServletException {
	        encoding = config.getInitParameter("requestEncoding");
	        if (encoding == null) encoding = "UTF-8";
	    }
	 
	    public void doFilter1(ServletRequest request, ServletResponse response, FilterChain next)
	            throws IOException, ServletException {
	        
	        if (null == request.getCharacterEncoding()) {
	            request.setCharacterEncoding(encoding);
	        }
	 
	        
	        response.setContentType("text/html; charset=UTF-8");
	        response.setCharacterEncoding("UTF-8");
	 
	        next.doFilter(request, response);
	    }
	 
	    public void destroy() {
	    }

		@Override
		public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
				throws IOException, ServletException {
		}

		@Override
		public void init(FilterConfig arg0) throws ServletException {	
		}


}