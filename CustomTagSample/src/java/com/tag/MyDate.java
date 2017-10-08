/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tag;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Vinhc
 */
public class MyDate extends SimpleTagSupport {

    private String pattern;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            Date today = new Date();
            SimpleDateFormat sdf = null;
            String s = "";
            try {
                sdf = new SimpleDateFormat(pattern);
                s = sdf.format(today);
            } catch (Exception e) {
                sdf = new SimpleDateFormat("dd/MM/yyyy");
                s = sdf.format(today);
            }
            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
            out.print(s);
        } catch (java.io.IOException ex) {
            throw new JspException("Error in MyDate tag", ex);
        }
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    
}
