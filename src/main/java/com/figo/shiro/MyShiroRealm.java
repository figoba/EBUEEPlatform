package com.figo.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Collection;

/**
 * Created by FigoBa on 2017/7/25.
 */
public class MyShiroRealm extends AuthorizingRealm{

    // 用于获取用户信息及用户权限信息的业务接口
    //private BusinessManager businessManager;

    // 获取授权信息
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        String username = (String) principals.fromRealm(
                getName()).iterator().next();

       /* if( username != null ){
            // 查询用户授权信息
            Collection<String> pers=businessManager.queryPermissions(username);
            if( pers != null && !pers.isEmpty() ){
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
                for( String each:pers )
                    info.addStringPermissions( each );

                return info;
            }
        }*/

        return null;
    }

    // 获取认证信息
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken ) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        // 通过表单接收的用户名
        String username = token.getUsername();

       /* if( username != null && !"".equals(username) ){
            LoginAccount account = businessManager.get( username );

            if( account != null ){
                return new SimpleAuthenticationInfo(
                        account.getLoginName(),account.getPassword(),getName() );
            }
        }*/

        return null;
    }
}
