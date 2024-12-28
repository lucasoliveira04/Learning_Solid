Classe ``UserService``:
```java
package org.solid.srp;

public class UserService {
    public void addUser(String name, String email) {
        System.out.println("Adicionando usuário: " + name + " - " + email);
    }

    public void sendWelcomeEmail(String email) {
        System.out.println("Email enviado para: " + email);
    }

    public void logActivity(String message) {
        System.out.println("Log: " + message);
    }
}

```

Nesta classe, o **UserService** tem várias responsibilidades:

1. Gerenciar usuários
2. Enviar e-mails
3. Fazer Log de atividades

Isso viola o SRP, porque mudanças em qualquer uma dessas responsabilidades podem afetar a classe inteira.

--- 

### Aplicando o SRP

Aqui está um exemplo refatorado, onde cada classe tem uma única responsabilidade:

Classe ``UserService``:
```java
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
```
--- 
Classe ``EmailService``:
```java
package org.solid.srp;

public class EmailService {
    public void sendEmail(String email) {
        System.out.println("Email de boas-vindas enviado para: " + email);
    }
}
```
--- 
Classe ``LogService``:
```java
package org.solid.srp;

public class LogService {
    public void logActivity(String message) {
        System.out.println("Log: " + message);
    }
}
```

### Benefícios
1. **Coesão**: Cada classe tem uma única responsibilidade.
2. **Reusabilidade**: Você pode reutilizar o ``EmailService`` e o ``LogService`` em outros contextos.
3. **Manutençaõ**: Mudanças em uma responsabilidade não afetam as outras.