package com.figo.webtest;

import com.figo.util.Email;
import com.figo.util.PropertyUtil;
import com.figo.util.SpringEmailUtil;

import java.io.File;

/**
 * Created by FigoBa on 2017/7/19.
 */
public class MailTest {
    public static void sendHTMLMail(){
        String emailAddress="figoba@163.com";
        //String verificationCode = RandomCodeUtil.createNumberAndLetterCode(4);
      /*  Register register = new Register();
        register.setEmail(emailAddress);
        register.setVerificationCode(verificationCode);
        registerDao.insertRegister(register);*/
//		SpringEmailUtil.sendEmail(email);
        Email email = new Email();
        email.setFromEmailAddress(PropertyUtil.getPropertyValue("mail.fromAddress"));
        email.setFromPersonName(PropertyUtil.getPropertyValue("mail.fromAddress"));
        email.setToEmailAddresses(new String[]{emailAddress});
        email.setSubject("微博客验证码");
       /* Map<String,Object> velocityContext = new HashMap<>();
        velocityContext.put("code", verificationCode);
        velocityContext.put("webAddress",PropertyUtil.getPropertyValue("web.address"));*/
        //String content = VelocitiesUtil.getVelocityText("email_register.vm", velocityContext);
        email.setContent( "<html><head></head><body><h1>hello!!spring html Mail</h1></body></html>");
        File attachedFile=new File("D:/aa.zip");
        email.setAttachment(attachedFile);
        try {
            SpringEmailUtil.sendEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
