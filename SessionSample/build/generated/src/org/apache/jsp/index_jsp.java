package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 Date today = new Date();
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <form action=\"index.jsp\" method=\"POST\">\n");
      out.write("            <p>Start: <input type=\"text\" name=\"txtStart\" value=\"\" />\n");
      out.write("            <p>End: <input type=\"text\" name=\"txtEnd\" value=\"\" />\n");
      out.write("            <p><input type=\"submit\" name=\"btnSubmit\" value=\"Submit\" />\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        ");

            if (request.getParameter("btnSubmit") != null) {
                //  get values of start and end
                int start = Integer.parseInt(request.getParameter("txtStart"));
                int end = Integer.parseInt(request.getParameter("txtEnd"));
        
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Miles</th>\n");
      out.write("                <th>Kilometers</th>\n");
      out.write("            </tr>\n");
      out.write("            ");

                for (int i = start; i <= end; i++) {
                    double miles = i;
                    double km = 1.6 * i;
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(miles);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(String.format("%.2f", km));
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </table>\n");
      out.write("        ");
 }
      out.write("\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        ");
      out.write("\n");
      out.write("        <h1> Today is ");
      out.print( today);
      out.write(" </h1>\n");
      out.write("        ");
for (int i = 1; i <= 6; i++) {
      out.write("\n");
      out.write("        <p><font size=\"");
      out.print( i);
      out.write(" \"> Welcome to JSP</font>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
