package com.Vehicle_Reservation.Vehicle_Reservation_System.security;

import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Users;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsImplementation implements UserDetails {

    private String name;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserDetailsImplementation(Users user){
        name  = user.getName();
        password = user.getPassword();
        authorities = Stream.of(user.getRole()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
