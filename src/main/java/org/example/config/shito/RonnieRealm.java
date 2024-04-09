package org.example.config.shito;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RonnieRealm extends AuthorizingRealm {
    // 身份驗證
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        String username = userToken.getUsername();

        if (username == null) {
            throw new AuthenticationException("Invalid username");
        }
        System.out.println("host = " + ((UsernamePasswordToken) token).getHost());

        return new SimpleAuthenticationInfo(username, userToken.getPassword(),  getName());
    }

    // 授權
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        System.out.println("authorization user = " + username);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        // 這裡只是一個示例，您應該從數據庫或其他數據源中獲取用戶的角色和權限
        Set<String> roles = new HashSet<>();
        roles.add("admin");
        authorizationInfo.setRoles(roles);

        Set<String> permissions = new HashSet<>();
        permissions.add("crud");
        authorizationInfo.setStringPermissions(permissions);

        return authorizationInfo;
    }
}
