package com.figo.controller;

//import com.figo.model.sys.SysUserEntity;

import com.figo.model.TUser;
import com.figo.service.IVUserRightMapper;
import com.figo.service.STuser;

import com.figo.util.R;
import com.figo.util.ShiroUtils;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

import org.apache.commons.io.IOUtils;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 登录相关
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月10日 下午1:15:31
 */
@RestController
public class SysLoginController {
	@Autowired
	private Producer producer;
	@Autowired
	private STuser sTuser;
	@Autowired
	private IVUserRightMapper ivUserRightMapper;
/*	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserTokenService sysUserTokenService;*/
    private final static int EXPIRE = 3600 * 12;

	@RequestMapping("captcha.jpg")
	public void captcha(HttpServletResponse response, HttpServletRequest request)throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		//生成文字验证码
		String text = producer.createText();
		//生成图片验证码
		BufferedImage image = producer.createImage(text);
		//保存到shiro session
		//ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);


		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
		IOUtils.closeQuietly(out);
	}

	/**
	 * 登录
	 */
	@RequestMapping(value = "/sys/login", method = RequestMethod.POST)
	public Map<String, Object> login(String username, String password, String captcha,HttpServletRequest request)throws IOException {
		//String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
		String kaptcha=request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
		System.out.println(kaptcha);
		System.out.println(captcha);
		if(!captcha.equalsIgnoreCase(kaptcha)){
			return R.error("验证码不正确");
		}

		//用户信息
		TUser user = sTuser.queryByUserName(username);

		//账号不存在、密码错误
		if(user == null || !user.getUserPwd().equals(password)) {
			return R.error("账号或密码不正确");
		}
		List<String> list_rights=ivUserRightMapper.get_user_rights(user.getRoleId(),"pcb");
		request.getSession().setAttribute("rights",list_rights);

		/*//账号锁定
		if(user.getStatus() == 0){
			return R.error("账号已被锁定,请联系管理员");
		}*/

		//生成token，并保存到数据库
        R r = R.ok().put("token", user).put("expire", EXPIRE);

		return r;
	}


	
}
