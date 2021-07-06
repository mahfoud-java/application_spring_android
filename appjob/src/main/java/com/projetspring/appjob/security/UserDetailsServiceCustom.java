package com.projetspring.appjob.security;

import com.projetspring.appjob.dao.DaoUtilisateur;
import com.projetspring.appjob.model.Utilisateur;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    private final DaoUtilisateur utilisateurDao;

    public UserDetailsServiceCustom(DaoUtilisateur utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }

    @Override
    public UserDetails loadUserByUsername(String emailSaisie) throws UsernameNotFoundException {

        Utilisateur utilisateur = utilisateurDao
                .findByEmail(emailSaisie)
                .orElseThrow(() -> new UsernameNotFoundException(emailSaisie + " inconnu"));

        return new UserDetailsCustom(utilisateur);
    }
}
