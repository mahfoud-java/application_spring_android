package com.projetspring.appjob.Controller;

import com.projetspring.appjob.dao.DaoUtilisateur;
import com.projetspring.appjob.model.Role;
import com.projetspring.appjob.model.Utilisateur;
import com.projetspring.appjob.security.JwtUtil;
import com.projetspring.appjob.security.UserDetailsServiceCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
  
@RestController
@CrossOrigin
public class UtilisateurController {

    DaoUtilisateur daoUtilisateur;
    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;
    private UserDetailsServiceCustom userDetailsServiceCustom;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UtilisateurController(DaoUtilisateur daoUtilisateur, JwtUtil jwtUtil, AuthenticationManager authenticationManager, UserDetailsServiceCustom userDetailsServiceCustom, PasswordEncoder passwordEncoder) {
        this.daoUtilisateur = daoUtilisateur;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.userDetailsServiceCustom = userDetailsServiceCustom;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/inscription")
    public ResponseEntity<String> inscription(@RequestBody Utilisateur utilisateur){

        Optional<Utilisateur> utilisateurDoublon = daoUtilisateur.findByEmail(utilisateur.getEmail());

        if(utilisateurDoublon.isPresent()) {
            return ResponseEntity.badRequest().body("Ce email est déja utilisé");
        } else {

            utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
            Role roleUtilisateur = new Role();
           roleUtilisateur.setId(3);


            utilisateur.getListeRoles().add(roleUtilisateur);

            daoUtilisateur.saveAndFlush(utilisateur);

            return ResponseEntity.ok(Integer.toString(utilisateur.getId()));
        }
    }
    @PostMapping("/authentification")
    public ResponseEntity<String> authentification(@RequestBody Utilisateur utilisateur) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            utilisateur.getEmail(), utilisateur.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body("Mauvais pseudo / mot de passe");
        }

        UserDetails userDetails = this.userDetailsServiceCustom.loadUserByUsername(utilisateur.getEmail());

        return ResponseEntity.ok(jwtUtil.generateToken(userDetails));
    }
    @GetMapping("/test/{id}")
    public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable int id) {

        Optional<Utilisateur> utilisateur = daoUtilisateur.findById(id);

        if(utilisateur.isPresent()) {
            return ResponseEntity.ok(utilisateur.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/user/utilisateur-connecte")
    public ResponseEntity<Utilisateur> getInformationUtilisateurConnecte(
            @RequestHeader(value="Authorization") String authorization){
        //la valeur du champs authorization est extrait de l'entête de la requête

        //On supprime la partie "Bearer " de la valeur de l'authorization
        String token = authorization.substring(7);

        //on extrait l'information souhaitée du token
        String email = jwtUtil.getTokenBody(token).getSubject();

        Optional<Utilisateur> utilisateur = daoUtilisateur.findByEmail(email);

        if(utilisateur.isPresent()) {
            return ResponseEntity.ok().body(utilisateur.get());
        }

        return ResponseEntity.notFound().build();
    }
}
