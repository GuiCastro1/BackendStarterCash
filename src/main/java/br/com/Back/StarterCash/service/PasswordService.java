package br.com.Back.StarterCash.service;
import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
//
//    private final int cost; // work factor (ex: 10..12)
//
//    public PasswordService() {
//        this(12); // padrão
//    }
//
//    public PasswordService(int cost) {
//        this.cost = cost;
//    }
//
//    // gerar hash (armazenar esse hash no DB)
//    public String hash(String plainPassword) {
//        // hashToString já inclui o salt no resultado (formato $2a$cost$...)
//        return BCrypt.withDefaults().hashToString(cost, plainPassword.toCharArray());
//    }
//
//    // verificar senha: compara plain com o hash armazenado
//    public boolean verify(String plainPassword, String hashedPassword) {
//        BCrypt.Result result = BCrypt.verifyer().verify(plainPassword.toCharArray(), hashedPassword);
//        return result.verified;
//    }

    private final int cost = 12; // work factor - ajuste conforme necessário (10..14)

    public String hash(String plainPassword) {
        return BCrypt.withDefaults().hashToString(cost, plainPassword.toCharArray());
    }

    public boolean verify(String plainPassword, String hashedPassword) {
        return BCrypt.verifyer().verify(plainPassword.toCharArray(), hashedPassword).verified;
    }



}