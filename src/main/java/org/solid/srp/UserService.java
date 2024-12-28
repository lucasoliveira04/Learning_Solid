package org.solid.srp;

public class UserService {
    private final EmailService emailService;
    private final LogService logService;

    public UserService(EmailService emailService, LogService logService) {
        this.emailService = emailService;
        this.logService = logService;
    }

    public void addUser(String name, String email) {
        System.out.println("Usuario adicionado: " + name);

        emailService.sendEmail(email);
        logService.logActivity("Usuário " + name + " adicionado");
    }
}
