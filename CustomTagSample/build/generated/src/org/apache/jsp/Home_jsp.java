package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/tlds/MyTLD.tld");
  }

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      if (_jspx_meth_mt_Login_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        <h1>Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.LoginUsr}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h1>\n");
      out.write("        <h1>Today is ");
      if (_jspx_meth_mt_MyDate_0(_jspx_page_context))
        return;
      out.write("</h1>\n");
      out.write("        <h1>Today is ");
      if (_jspx_meth_mt_MyDate_1(_jspx_page_context))
        return;
      out.write("</h1>\n");
      out.write("        <table border=\"1\" cellspacing=\"0\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Index</th><th>Unicode Character</th>\n");
      out.write("            </tr>\n");
      out.write("            ");
      if (_jspx_meth_mt_MyUnicode_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </table>\n");
      out.write("        \n");
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

  private boolean _jspx_meth_mt_Login_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mt:Login
    com.tag.Login _jspx_th_mt_Login_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.tag.Login.class) : new com.tag.Login();
    _jspx_th_mt_Login_0.setJspContext(_jspx_page_context);
    _jspx_th_mt_Login_0.setUrl("Login.jsp");
    _jspx_th_mt_Login_0.setMessage("You have to login first");
    _jspx_th_mt_Login_0.doTag();
    return false;
  }

  private boolean _jspx_meth_mt_MyDate_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mt:MyDate
    com.tag.MyDate _jspx_th_mt_MyDate_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.tag.MyDate.class) : new com.tag.MyDate();
    _jspx_th_mt_MyDate_0.setJspContext(_jspx_page_context);
    _jspx_th_mt_MyDate_0.setPattern("MM/dd/yyyy");
    _jspx_th_mt_MyDate_0.doTag();
    return false;
  }

  private boolean _jspx_meth_mt_MyDate_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mt:MyDate
    com.tag.MyDate _jspx_th_mt_MyDate_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.tag.MyDate.class) : new com.tag.MyDate();
    _jspx_th_mt_MyDate_1.setJspContext(_jspx_page_context);
    _jspx_th_mt_MyDate_1.setPattern("abc");
    _jspx_th_mt_MyDate_1.doTag();
    return false;
  }

  private boolean _jspx_meth_mt_MyUnicode_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mt:MyUnicode
    com.tag.MyUnicode _jspx_th_mt_MyUnicode_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(com.tag.MyUnicode.class) : new com.tag.MyUnicode();
    _jspx_th_mt_MyUnicode_0.setJspContext(_jspx_page_context);
    _jspx_th_mt_MyUnicode_0.setStart(1001);
    _jspx_th_mt_MyUnicode_0.setEnd(1093);
    _jspx_th_mt_MyUnicode_0.setJspBody(new Home_jspHelper( 0, _jspx_page_context, _jspx_th_mt_MyUnicode_0, null));
    _jspx_th_mt_MyUnicode_0.doTag();
    return false;
  }

  private class Home_jspHelper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public Home_jspHelper( int discriminator, JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <th>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</th><th>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.c}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</th>\n");
      out.write("                </tr>\n");
      out.write("            ");
      return false;
    }
    public void invoke( java.io.Writer writer )
      throws JspException
    {
      JspWriter out = null;
      if( writer != null ) {
        out = this.jspContext.pushBody(writer);
      } else {
        out = this.jspContext.getOut();
      }
      try {
        switch( this.discriminator ) {
          case 0:
            invoke0( out );
            break;
        }
      }
      catch( Throwable e ) {
        if (e instanceof SkipPageException)
            throw (SkipPageException) e;
        throw new JspException( e );
      }
      finally {
        if( writer != null ) {
          this.jspContext.popBody();
        }
      }
    }
  }
}
