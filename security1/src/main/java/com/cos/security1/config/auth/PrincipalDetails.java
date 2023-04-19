package com.cos.security1.config.auth;

//시큐리티가 /login주소 요청을 낚아채서 로그인을 진행시킨다
//로그인 진행이 완료되면 시큐리티가 가지고 있는 session을 만들어준다.(Security ContextHolder)
//Security ContextHolder 안의 오브젝트 -> Authentication 타입 객체
//Authentication 안에 User 정보가 있어야 댐.
//User오브젝트 타입 -> UserDetails타입 객체여야 함.

//Security Session -> Authentication -> UserDetails(PrincipalDetails)

import com.cos.security1.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


public class PrincipalDetails implements UserDetails { //로그인 할때 유저 정보가 담긴 객체를 다루기 위함.
    private User user;

    public PrincipalDetails(User user) {
        this.user = user;
    }

    //해당 유저의 권한을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword(){
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() { //만료되지 않았는가?
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //잠기지 않았는가?
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //비밀번호 기간만료 되었는가?
        return true;
    }

    @Override
    public boolean isEnabled() { //계정이 활성화 되었는가?
        return true;
    }
}
