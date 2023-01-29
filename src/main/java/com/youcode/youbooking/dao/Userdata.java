package com.youcode.youbooking.dao;


import com.youcode.youbooking.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;


@Repository
public class Userdata {

    private final UserRepository userRepository;

    public Userdata(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   /* private final static List<UserDetails> USER_APPLICATION= Arrays.asList(
            new User("khalil@gmail.com","khalil", Collections.singleton(new SimpleGrantedAuthority("ADMIN"))),
            new User("omar@gmail.com","omar", Collections.singleton(new SimpleGrantedAuthority("USER"))),
            new User("omar@gmail.com","omar", Collections.singleton(new SimpleGrantedAuthority("Fournisseur")))
    );*/
    public UserDetails findUserByEmail(String email){
        return  userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("No user Was Found"));
             /*   USER_APPLICATION.stream().filter(
                        userDetails -> userDetails.getUsername().equals(email)).findFirst()
                .orElseThrow(()->new UsernameNotFoundException("No user Was Found"));*/
    }
  /*  public UserDetails findByUserName(String userName){
        final AppUser appUserRepository=users().stream().filter(appUser -> appUser.getUserName().equals(userName)).
                findFirst().orElseThrow(()->new UsernameNotFoundException("No user Was Found"));
        return (UserDetails) appUserRepository;
    }
*/



}
